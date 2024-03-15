package com.alazizsoftwares.plugins.folderpicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.documentfile.provider.DocumentFile;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.JSObject;

@CapacitorPlugin(name = "FolderPicker")
public class FolderPickerPlugin extends Plugin {

    private ActivityResultLauncher<Intent> activityResultLauncher;
    private PluginCall savedCall;

    @Override
    public void load() {
        activityResultLauncher = getActivity().registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        handleOnActivityResult(result);
                    }
                });
    }

    @PluginMethod
    public void chooseFolder(PluginCall call) {
        savedCall = call;

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
        activityResultLauncher.launch(intent);
    }

    public void handleOnActivityResult(ActivityResult result) {
        if (result.getResultCode() == Activity.RESULT_OK) {
            Intent intent = result.getData();
            Uri uri = intent.getData();
            Log.i("Directory Tree:", String.valueOf(uri));
            DocumentFile documentFile = DocumentFile.fromTreeUri(getContext(), uri);
            if (documentFile != null && documentFile.isDirectory()) {
                savedCall.success(toJSObject(uri.toString()));
            } else {
                savedCall.error("Invalid directory selected");
            }
        } else {
            savedCall.error("Folder selection canceled or failed");
        }
    }

    private JSObject toJSObject(String path) {
        JSObject object = new JSObject();
        object.put("path", path);
        return object;
    }
}
