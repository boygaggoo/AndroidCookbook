package com.aldoapps.androidtemplate.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

import java.io.File;

/**
 * Created by aldokelvianto on 13/06/16.
 */
public class SingleMediaScanner implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection mMs;
    private File mFile;

    public SingleMediaScanner(Context context, File f) {
        mFile = f;
        mMs = new MediaScannerConnection(context, this);
        mMs.connect();
    }

    @Override
    public void onMediaScannerConnected() {
        mMs.scanFile(mFile.getAbsolutePath(), null);
    }

    @Override
    public void onScanCompleted(String path, Uri uri) {
        mMs.disconnect();
    }
}
