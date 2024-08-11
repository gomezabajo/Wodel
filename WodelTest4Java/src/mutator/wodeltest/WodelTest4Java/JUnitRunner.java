package mutator.wodeltest.WodelTest4Java;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.engine.JupiterTestEngine;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherConfig;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.runner.Computer;

public class JUnitRunner implements Runnable {
	private final ExecutorService executor;
	private final Class<?> clazz;
	private final JUnitVersion version;
	private final SummaryGeneratingListener listener;
	private final int limit;
	private AtomicInteger count;
	
	private Object result = null;
	
	public JUnitRunner(ExecutorService executor, Class<?> clazz, JUnitVersion version, SummaryGeneratingListener listener, int limit) {
		this.executor = executor;
		this.clazz = clazz;
		this.version = version;
		this.listener = listener;
		this.limit = limit;
		this.count = new AtomicInteger(0);
	}

	public JUnitRunner(ExecutorService executor, Class<?> clazz, JUnitVersion version, SummaryGeneratingListener listener) {
		this(executor, clazz, version, listener, 1);
	}

	public JUnitRunner(ExecutorService executor, Class<?> clazz, JUnitVersion version) {
		this(executor, clazz, version, null);
	}

	private synchronized Object runJUnit4() {
		Class<?>[] classRunner = new Class<?>[1];
		classRunner[0] = clazz;
		Computer computer = new Computer();
		MyJUnitCore jUnitCore = new MyJUnitCore();
		try {
			this.result = jUnitCore.run(computer, classRunner);
			jUnitCore.finalize();
		} catch (Exception e) {
			return this.result;
		} catch (Throwable e) {
			return this.result;
		}
		return this.result;
	}

	private synchronized Object runJUnit5() {
		JupiterTestEngine testEngine = new JupiterTestEngine();
		LauncherConfig config = LauncherConfig.builder()
			    .enableTestExecutionListenerAutoRegistration(false)
			    .enableTestEngineAutoRegistration(false)
			    .enablePostDiscoveryFilterAutoRegistration(false)
			    .addTestEngines(testEngine)
			    .addTestExecutionListeners(listener)
			    .build();
		Launcher launcher = LauncherFactory.create(config);

		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
				.request()
				.selectors(selectClass(clazz))
				.build();
		TestPlan testPlan = launcher.discover(request);
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
		
		this.result = this.listener.getSummary();
		return this.result;
	}

	@Override
	public void run() {
		if (this.count.incrementAndGet() >= this.limit) {
			this.executor.shutdown();
		}
		if (this.version == JUnitVersion.JUNIT3 || version == JUnitVersion.JUNIT4) {
			this.result = this.runJUnit4();
			this.executor.shutdown();
		}
		else if (this.version == JUnitVersion.JUNIT5) {
			this.result = this.runJUnit5();
			this.executor.shutdown();
		}
	}
	
	public synchronized Object getResult() {
		return this.result;
	}
}
