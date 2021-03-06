package org.fdroid.fdroid.views.apps;

import android.view.View;

import org.fdroid.fdroid.AppUpdateStatusManager;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.data.App;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Used for search results or for category lists.
 * Shows an inline download button, and also (if appropriate):
 * <ul>
 * <li>Whether the app is incompatible
 * <li>Version that app can be upgraded to
 * <li>Installed version
 * </ul>
 */
public class StandardAppListItemController extends AppListItemController {
    public StandardAppListItemController(AppCompatActivity activity, View itemView) {
        super(activity, itemView);
    }

    @NonNull
    @Override
    protected AppListItemState getCurrentViewState(
            @NonNull App app, @Nullable AppUpdateStatusManager.AppUpdateStatus appStatus) {

        return super.getCurrentViewState(app, appStatus)
                .setStatusText(getStatusText(app))
                .setShowInstallButton(shouldShowInstall(app));
    }

    @Nullable
    private CharSequence getStatusText(@NonNull App app) {
        if (!app.compatible) {
            return activity.getString(R.string.app_incompatible);
        } else if (app.antiFeatures != null && app.antiFeatures.length > 0) {
            return activity.getString(R.string.antifeatures);
        } else if (app.isInstalled(activity.getApplicationContext())) {
            if (app.canAndWantToUpdate(activity)) {
                return activity.getString(R.string.app_version_x_available, app.getAutoInstallVersionName());
            } else {
                return activity.getString(R.string.app_version_x_installed, app.installedVersionName);
            }
        }

        return null;
    }

    private boolean shouldShowInstall(@NonNull App app) {
        boolean installable = app.canAndWantToUpdate(activity) || !app.isInstalled(activity.getApplicationContext());
        boolean shouldAllow = app.compatible && (app.antiFeatures == null || app.antiFeatures.length == 0);

        return installable && shouldAllow;
    }
}
