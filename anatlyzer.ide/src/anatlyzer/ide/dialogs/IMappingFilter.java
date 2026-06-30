package anatlyzer.ide.dialogs;

import org.eclipse.jface.viewers.Viewer;

import anatlyzer.ide.dialogs.ITransformationMapping.MetamodelElementMapping;

public interface IMappingFilter<M> {
    /**
     * Determines whether the given mapping link should be displayed.
     * 
     * @param mapping The mapping object containing data about the connection.
     * @return true if the mapping should be visible; false to hide it.
     */
    public boolean isSelected(MetamodelElementMapping mapping);
    
    public boolean selectLeft(Viewer viewer, Object parentElement, Object element);
    
    public boolean selectRight(Viewer viewer, Object parentElement, Object element);
   
}
