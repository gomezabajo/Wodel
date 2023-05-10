/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - add scope of a comparison to its adapters, progress reporting
 *******************************************************************************/
package wodel.utils.manager;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.ComparisonCanceledException;
import org.eclipse.emf.compare.conflict.IConflictDetector;
import org.eclipse.emf.compare.conflict.MatchBasedConflictDetector;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.equi.DefaultEquiEngine;
import org.eclipse.emf.compare.equi.IEquiEngine;
import org.eclipse.emf.compare.internal.spec.ComparisonSpec;
import org.eclipse.emf.compare.internal.utils.SafeSubMonitor;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.merge.ResourceChangeAdapter;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.postprocessor.PostProcessorDescriptorRegistryImpl;
import org.eclipse.emf.compare.req.DefaultReqEngine;
import org.eclipse.emf.compare.req.IReqEngine;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.compare.EMFCompareMessages;

/**
 * This class serves as the main entry point of a comparison. When all that is wanted is a basic comparison of
 * two or three notifiers, a comparison using all of the default configuration can be launched through
 * <code>EMFCompare.builder().build().compare(EMFCompare.createDefaultScope(left, right, origin))</code>.
 * <p>
 * When in need of a more customized comparison, the API can be used through chained calls. For example, if
 * you need to compare two notifiers ({@code left} and {@code right}) while ignoring their identifiers, with a
 * given progress monitor (call it {@code progress}), you can do so through : <code>
 * EMFCompare.builder().setMatchEngine(DefaultMatchEngine.create(UseIdentifiers.NEVER)).build().compare(EMFCompare.createDefaultScope(left, right), new BasicMonitor())
 * </code>.
 * </p>
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public class EMFCompare {

	/**
	 * The value for diagnostics coming from EMF compare.
	 * 
	 * @since 3.2
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.emf.compare"; //$NON-NLS-1$

	/** The registry we'll use to create a match engine for this comparison. */
	private final IMatchEngine.Factory.Registry matchEngineFactoryRegistry;

	/** The IDiffEngine to use to compute comparison. */
	private final IDiffEngine diffEngine;

	/** The IReqEngine to use to compute comparison. */
	private final IReqEngine reqEngine;

	/** The IEquiEngine to use to compute comparison. */
	private final IEquiEngine equiEngine;

	/** The IConflictDetector to use to compute comparison. */
	private final IConflictDetector conflictDetector;

	/** The PostProcessorRegistry to use to find an IPostProcessor. */
	private final IPostProcessor.Descriptor.Registry<?> postProcessorDescriptorRegistry;

	/**
	 * Creates a new EMFCompare object able to compare Notifier with the help of given engines.
	 * 
	 * @param matchEngineFactoryRegistry
	 *            {@link IMatchEngine.Factory.Registry} to use to find a match engine factory to compute
	 *            comparison
	 * @param diffEngine
	 *            IDiffEngine to use to compute comparison
	 * @param reqEngine
	 *            IReqEngine to use to compute comparison
	 * @param equiEngine
	 *            IEquiEngine to use to compute comparison
	 * @param conflictDetector
	 *            IConflictDetector to use to compute comparison
	 * @param postProcessorFactoryRegistry
	 *            PostProcessorRegistry to use to find an IPostProcessor
	 */
	protected EMFCompare(IMatchEngine.Factory.Registry matchEngineFactoryRegistry, IDiffEngine diffEngine,
			IReqEngine reqEngine, IEquiEngine equiEngine, IConflictDetector conflictDetector,
			IPostProcessor.Descriptor.Registry<?> postProcessorFactoryRegistry) {
		this.matchEngineFactoryRegistry = checkNotNull(matchEngineFactoryRegistry);
		this.diffEngine = checkNotNull(diffEngine);
		this.reqEngine = checkNotNull(reqEngine);
		this.equiEngine = checkNotNull(equiEngine);
		this.conflictDetector = conflictDetector;
		this.postProcessorDescriptorRegistry = checkNotNull(postProcessorFactoryRegistry);
	}

	/**
	 * Creates a default comparison scope given its left and right notifiers.
	 * <p>
	 * The default comparison scope covers all proper content of the given notifiers, i.e any element
	 * contained directly under that notifier.
	 * </p>
	 * 
	 * @param left
	 *            The left notifier of this scope.
	 * @param right
	 *            The right notifier of this scope.
	 * @return The newly created scope, as used as default by EMF Compare.
	 * @see DefaultComparisonScope
	 * @deprecated this was only a delegation to the publicly accessible {@link DefaultComparisonScope}... it
	 *             will be removed in a subsequent release.
	 */
	@Deprecated
	public static IComparisonScope createDefaultScope(Notifier left, Notifier right) {
		return new DefaultComparisonScope(left, right, null);
	}

	/**
	 * Creates the default comparison scope given its left and right notifiers, along with the common ancestor
	 * of both.
	 * <p>
	 * The default comparison scope covers all proper content of the given notifiers, i.e any element
	 * contained directly under that notifier.
	 * </p>
	 * 
	 * @param left
	 *            The left notifier of this scope.
	 * @param right
	 *            The right notifier of this scope.
	 * @param origin
	 *            The common ancestor of {@code left} and {@code right}.
	 * @return The newly created scope, as used as default by EMF Compare.
	 * @see DefaultComparisonScope
	 * @deprecated this was only a delegation to the publicly accessible {@link DefaultComparisonScope}... it
	 *             will be removed in a subsequent release.
	 */
	@Deprecated
	public static IComparisonScope createDefaultScope(Notifier left, Notifier right, Notifier origin) {
		return new DefaultComparisonScope(left, right, origin);
	}

	/**
	 * Computes and returns a new Comparison object representation the differences between Notifier in the
	 * give {@code scope}.
	 * 
	 * @param scope
	 *            the scope to compare.
	 * @return the result of the comparison.
	 */
	public Comparison compare(IComparisonScope scope) {
		return compare(scope, new BasicMonitor());
	}

	/**
	 * Launches the comparison with the given scope and reporting progress to the given {@code monitor}.
	 * 
	 * @param scope
	 *            the scope to compare, must not be {@code null}.
	 * @param monitor
	 *            the monitor to report progress to, must not be {@code null}. {@code done()} will be called
	 *            on it. If the monitor is cancelled, the result may be {@code null} (in rare cases) or
	 *            contain a Diagnostic that indicates cancellation. <b>Note:</b> The given monitor is expected
	 *            to use 10 ticks for 100%.
	 * @return The result of the comparison, which is never null but may be empty if the monitor has been
	 *         canceled immediately after entering this method. The returned comparison will contain a
	 *         relevant diagnostic indicating if the comparison has been canceled or if problems have occurred
	 *         during its computation. Consequently, it is necessary to check the diagnostic of the returned
	 *         comparison before using it.
	 * @throws ComparisonCanceledException
	 *             If the comparison is cancelled at any time.
	 */
	public Comparison compare(IComparisonScope scope, final Monitor monitor) {
		checkNotNull(scope);
		checkNotNull(monitor);

		Comparison comparison = null;
		try {
			Monitor subMonitor = new SafeSubMonitor(monitor);
			comparison = matchEngineFactoryRegistry.getHighestRankingMatchEngineFactory(scope)
					.getMatchEngine().match(scope, subMonitor);

			installResourceChangeAdapter(comparison, scope);

			monitor.worked(1);
			List<IPostProcessor> postProcessors = postProcessorDescriptorRegistry.getPostProcessors(scope);

			// CHECKSTYLE:OFF Yes, I want to have ifs here and no constant for "post-processor".
			postMatch(comparison, postProcessors, subMonitor);
			monitor.worked(1);

			if (!hasToStop(comparison, monitor)) {
				diffEngine.diff(comparison, subMonitor);
				monitor.worked(1);
				postDiff(comparison, postProcessors, subMonitor);
				monitor.worked(1);

				if (!hasToStop(comparison, monitor)) {
					reqEngine.computeRequirements(comparison, subMonitor);
					monitor.worked(1);
					postRequirements(comparison, postProcessors, subMonitor);
					monitor.worked(1);

					if (!hasToStop(comparison, monitor)) {
						equiEngine.computeEquivalences(comparison, subMonitor);
						monitor.worked(1);
						postEquivalences(comparison, postProcessors, subMonitor);
						monitor.worked(1);

						detectConflicts(comparison, postProcessors, subMonitor);
						monitor.worked(1);

						// CHECKSTYLE:ON
						postComparison(comparison, postProcessors, subMonitor);
						monitor.worked(1);
					}
				}
			}
		} catch (ComparisonCanceledException e) {
			if (comparison == null) {
				comparison = new ComparisonSpec();
			}
			BasicDiagnostic cancelledDiag = new BasicDiagnostic(Diagnostic.CANCEL, DIAGNOSTIC_SOURCE, 0,
					EMFCompareMessages.getString("ComparisonCancelled"), null); //$NON-NLS-1$
			Diagnostic diag = comparison.getDiagnostic();
			if (diag != null && diag instanceof DiagnosticChain) {
				((DiagnosticChain)diag).merge(cancelledDiag);
			} else {
				comparison.setDiagnostic(cancelledDiag);
			}
		} finally {
			monitor.done();
		}

		// Add scope to the comparison's adapters to make it available throughout the framework
		if (scope instanceof Adapter) {
			comparison.eAdapters().add((Adapter)scope);
		}

		return comparison;
	}

	/**
	 * Install a new {@link ResourceChangeAdapter} on the given comparison and on all the resources on the
	 * left and right side of the scope, unless it's already been done. If a {@link ResourceChangeAdapter} is
	 * already registered on the given comparison, nothing happens. Otherwise, a new
	 * {@link ResourceChangeAdapter} is created and installed on the comparison and on all the
	 * {@link ResourceSet}s and {@link Resource}s of the left and right sides of the scope if its left and
	 * right notifiers are actually {@link ResourceSet}s.
	 * 
	 * @param comparison
	 *            The comparison
	 * @param scope
	 *            The scope
	 */
	private void installResourceChangeAdapter(Comparison comparison, IComparisonScope scope) {
		if (scope.getLeft() instanceof ResourceSet && scope.getRight() instanceof ResourceSet) {
			Adapter existingAdapter = EcoreUtil.getExistingAdapter(comparison, ResourceChangeAdapter.class);
			if (existingAdapter == null) {
				ResourceChangeAdapter adapter = new ResourceChangeAdapter(comparison, scope);
				comparison.eAdapters().add(adapter);
				ResourceSet left = (ResourceSet)scope.getLeft();
				left.eAdapters().add(adapter);
				for (Resource r : left.getResources()) {
					r.eAdapters().add(adapter);
				}
				ResourceSet right = (ResourceSet)scope.getRight();
				right.eAdapters().add(adapter);
				for (Resource r : right.getResources()) {
					r.eAdapters().add(adapter);
				}
			}
		}
	}

	/**
	 * Launches the conflict detection engine, if any has been given and if the comparison is three way.
	 * 
	 * @param comparison
	 *            the comparison in which the conflict has to be detected
	 * @param postProcessors
	 *            the list of post processors to be used after conflict detection
	 * @param monitor
	 *            monitor to report progress to or cancellation
	 */
	private void detectConflicts(final Comparison comparison, List<IPostProcessor> postProcessors,
			final Monitor monitor) {
		if (!hasToStop(comparison, monitor) && comparison.isThreeWay() && conflictDetector != null) {
			conflictDetector.detect(comparison, monitor);
			postConflicts(comparison, postProcessors, monitor);
		}
	}

	/**
	 * Post processes the comparison after the match engine has been applied.
	 * 
	 * @param comparison
	 *            the comparison on which the post processors has to be applied
	 * @param postProcessors
	 *            the list of post processors to be use
	 * @param monitor
	 *            monitor to report progress to or cancellation
	 */
	private void postMatch(final Comparison comparison, List<IPostProcessor> postProcessors,
			final Monitor monitor) {
		Iterator<IPostProcessor> processorsIterator = postProcessors.iterator();
		while (!hasToStop(comparison, monitor) && processorsIterator.hasNext()) {
			final IPostProcessor iPostProcessor = processorsIterator.next();
			iPostProcessor.postMatch(comparison, monitor);
		}
	}

	/**
	 * Post processes the comparison after the diff engine has been applied.
	 * 
	 * @param comparison
	 *            the comparison on which the post processors has to be applied
	 * @param postProcessors
	 *            the list of post processors to be use
	 * @param monitor
	 *            monitor to report progress to or cancellation
	 */
	private void postDiff(final Comparison comparison, List<IPostProcessor> postProcessors,
			final Monitor monitor) {
		Iterator<IPostProcessor> processorsIterator = postProcessors.iterator();
		while (!hasToStop(comparison, monitor) && processorsIterator.hasNext()) {
			final IPostProcessor iPostProcessor = processorsIterator.next();
			iPostProcessor.postDiff(comparison, monitor);
		}
	}

	/**
	 * Post processes the comparison after the requirement engine has been applied.
	 * 
	 * @param comparison
	 *            the comparison on which the post processors has to be applied
	 * @param postProcessors
	 *            the list of post processors to be use
	 * @param monitor
	 *            monitor to report progress to or cancellation
	 */
	private void postRequirements(final Comparison comparison, List<IPostProcessor> postProcessors,
			final Monitor monitor) {
		Iterator<IPostProcessor> processorsIterator = postProcessors.iterator();
		while (!hasToStop(comparison, monitor) && processorsIterator.hasNext()) {
			final IPostProcessor iPostProcessor = processorsIterator.next();
			iPostProcessor.postRequirements(comparison, monitor);
		}
	}

	/**
	 * Post processes the comparison after the equivalence engine has been applied.
	 * 
	 * @param comparison
	 *            the comparison on which the post processors has to be applied
	 * @param postProcessors
	 *            the list of post processors to be use
	 * @param monitor
	 *            monitor to report progress to or cancellation
	 */
	private void postEquivalences(final Comparison comparison, List<IPostProcessor> postProcessors,
			final Monitor monitor) {
		Iterator<IPostProcessor> processorsIterator = postProcessors.iterator();
		while (!hasToStop(comparison, monitor) && processorsIterator.hasNext()) {
			final IPostProcessor iPostProcessor = processorsIterator.next();
			iPostProcessor.postEquivalences(comparison, monitor);
		}
	}

	/**
	 * Post processes the comparison after the conflict engine has been applied.
	 * 
	 * @param comparison
	 *            the comparison on which the post processors has to be applied
	 * @param postProcessors
	 *            the list of post processors to be use
	 * @param monitor
	 *            monitor to report progress to or cancellation
	 */
	private void postConflicts(final Comparison comparison, List<IPostProcessor> postProcessors,
			final Monitor monitor) {
		Iterator<IPostProcessor> processorsIterator = postProcessors.iterator();
		while (!hasToStop(comparison, monitor) && processorsIterator.hasNext()) {
			final IPostProcessor iPostProcessor = processorsIterator.next();
			iPostProcessor.postConflicts(comparison, monitor);
		}
	}

	/**
	 * Post processes the comparison after it has been computed.
	 * 
	 * @param comparison
	 *            the comparison on which the post processors has to be applied
	 * @param postProcessors
	 *            the list of post processors to be use
	 * @param monitor
	 *            monitor to report progress to or cancellation
	 */
	private void postComparison(final Comparison comparison, List<IPostProcessor> postProcessors,
			final Monitor monitor) {
		final Iterator<IPostProcessor> processorsIterator = postProcessors.iterator();
		int postProcessorIndex = 1;
		while (!hasToStop(comparison, monitor) && processorsIterator.hasNext()) {
			final IPostProcessor postProcessor = processorsIterator.next();
			monitor.subTask(EMFCompareMessages.getString("PostComparison.monitor.postprocessor", //$NON-NLS-1$
					postProcessor.getClass().getSimpleName(), String.valueOf(postProcessorIndex),
					String.valueOf(postProcessors.size())));
			postProcessor.postComparison(comparison, monitor);
			postProcessorIndex++;
		}
	}

	/**
	 * It checks if the comparison has to be stopped.
	 * 
	 * @param comparison
	 *            The comparison.
	 * @param monitor
	 *            The monitor.
	 * @return True if the comparison has to be stopped. False otherwise.
	 */
	private static boolean hasToStop(Comparison comparison, Monitor monitor) {
		return monitor.isCanceled() || (comparison.getDiagnostic() != null
				&& comparison.getDiagnostic().getSeverity() >= Diagnostic.ERROR);
	}

	/**
	 * Creates a new builder to configure the creation of a new EMFCompare object.
	 * 
	 * @return a new builder.
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * A Builder pattern to instantiate EMFCompare objects.
	 * 
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 */
	public static class Builder {

		/** The registry we'll use to create a match engine for this comparison. */
		protected IMatchEngine.Factory.Registry matchEngineFactoryRegistry;

		/** The IReqEngine to use to compute comparison. */
		protected IReqEngine reqEngine;

		/** The IDiffEngine to use to compute comparison. */
		protected IDiffEngine diffEngine;

		/** The IEquiEngine to use to compute comparison. */
		protected IEquiEngine equiEngine;

		/** The IConflictDetector to use to compute conflicts. */
		protected IConflictDetector conflictDetector;

		/** The PostProcessorRegistry to use to find an IPostProcessor. */
		protected IPostProcessor.Descriptor.Registry<?> registry;

		/**
		 * Creates a new builder object.
		 */
		protected Builder() {
		}

		/**
		 * Sets the IMatchEngine.Factory.Registry to be used to find a match engine factory to compute
		 * comparison.
		 * 
		 * @param mefr
		 *            the IMatchEngine.Factory.Registry to be used to find a match engine factory to compute
		 *            comparison.
		 * @return this same builder to allow chained call.
		 */
		public Builder setMatchEngineFactoryRegistry(IMatchEngine.Factory.Registry mefr) {
			this.matchEngineFactoryRegistry = checkNotNull(mefr);
			return this;
		}

		/**
		 * Sets the IDiffEngine to be used to compute Diff.
		 * 
		 * @param de
		 *            the IDiffEngine to be used to compute Diff.
		 * @return this same builder to allow chained call.
		 */
		public Builder setDiffEngine(IDiffEngine de) {
			this.diffEngine = checkNotNull(de);
			return this;
		}

		/**
		 * Sets the IReqEngine to be used to compute dependencies between Diff.
		 * 
		 * @param re
		 *            the IReqEngine to be used to compute dependencies between Diff.
		 * @return this same builder to allow chained call.
		 */
		public Builder setRequirementEngine(IReqEngine re) {
			this.reqEngine = checkNotNull(re);
			return this;
		}

		/**
		 * Sets the IEquiEngine to be used to compute equivalences between Diff.
		 * 
		 * @param ee
		 *            the IEquiEngine to be used to compute equivalences between Diff
		 * @return this same builder to allow chained call.
		 */
		public Builder setEquivalenceEngine(IEquiEngine ee) {
			this.equiEngine = checkNotNull(ee);
			return this;
		}

		/**
		 * Sets the IEquiEngine to be used to compute conflicts between Diff.
		 * 
		 * @param cd
		 *            the IEquiEngine to be used to compute conflicts between Diff.
		 * @return this same builder to allow chained call.
		 */
		public Builder setConflictDetector(IConflictDetector cd) {
			this.conflictDetector = checkNotNull(cd);
			return this;
		}

		/**
		 * Sets the PostProcessor to be used to find the post processor of each comparison steps.
		 * 
		 * @param r
		 *            the PostProcessor to be used to find the post processor of each comparison steps.
		 * @return this same builder to allow chained call.
		 */
		public Builder setPostProcessorRegistry(IPostProcessor.Descriptor.Registry<?> r) {
			this.registry = checkNotNull(r);
			return this;
		}

		/**
		 * Instantiates and return an EMFCompare object configured with the previously given engines.
		 * 
		 * @return an EMFCompare object configured with the previously given engines
		 */
		public EMFCompare build() {
			if (matchEngineFactoryRegistry == null) {
				matchEngineFactoryRegistry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
			}
			if (diffEngine == null) {
				diffEngine = new DefaultDiffEngine(new DiffBuilder());
			}
			if (reqEngine == null) {
				reqEngine = new DefaultReqEngine();
			}
			if (equiEngine == null) {
				equiEngine = new DefaultEquiEngine();
			}
			if (registry == null) {
				registry = new PostProcessorDescriptorRegistryImpl<Object>();
			}
			if (conflictDetector == null) {
				conflictDetector = new MatchBasedConflictDetector();
			}
			return new EMFCompare(this.matchEngineFactoryRegistry, this.diffEngine, this.reqEngine,
					this.equiEngine, this.conflictDetector, this.registry);
		}
	}

}
