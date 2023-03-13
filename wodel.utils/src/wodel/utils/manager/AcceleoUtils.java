package wodel.utils.manager;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
//import org.eclipse.acceleo.internal.ide.ui.builders.AcceleoBuilderSettings;
//import org.eclipse.core.resources.IProject;

public class AcceleoUtils {

	public static boolean SwitchSuccessNotification(boolean notify) {
		boolean successNotifications = AcceleoPreferences.areSuccessNotificationsEnabled();
		if(successNotifications != notify)
		{
			AcceleoPreferences.switchSuccessNotifications(notify);
			return successNotifications;
		}
		return successNotifications;
	}

//	public static void setCompilationKind(IProject project, String compilationKind) {
//		AcceleoBuilderSettings settings = new AcceleoBuilderSettings(project);
//		settings.setCompilationKind(compilationKind);
//	}

//	public static void setResourceKind(IProject project, String resourceKind) {
//		AcceleoBuilderSettings settings = new AcceleoBuilderSettings(project);
//		settings.setResourceKind(resourceKind);
//	}
}
