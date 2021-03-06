// Copyright (c) 2014 Intel Corporation. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.xwalk.embedded.api.asyncsample.misc;

import org.xwalk.embedded.api.asyncsample.R;

import org.xwalk.embedded.api.asyncsample.misc.ExtensionEcho;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkView;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class XWalkViewWithEchoExtensionAsync extends Activity implements XWalkInitializer.XWalkInitListener {
    private ExtensionEcho mExtension;
    private XWalkView mXWalkView1;
    private XWalkView mXWalkView2;
    private XWalkInitializer mXWalkInitializer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mXWalkInitializer = new XWalkInitializer(this, this);
        mXWalkInitializer.initAsync();
    }

    @Override
    public final void onXWalkInitStarted() {
        // It's okay to do nothing
    }

    @Override
    public final void onXWalkInitCancelled() {
        // It's okay to do nothing
    }

    @Override
    public final void onXWalkInitFailed() {
        // Do crash or logging or anything else in order to let the tester know if this method get called
    }

    @Override
    public final void onXWalkInitCompleted() {
        StringBuffer mess = new StringBuffer();
        mess.append("Test Purpose: \n\n")
        .append("Verifies extension synchronous and asynchronous mode can be supported .\n\n")
        .append("Expected Result:\n\n")
        .append("Test passes if the display of app contains 'passed' in green color in synchronous and asynchronous message mode.");
        new  AlertDialog.Builder(this)
        .setTitle("Info" )
        .setMessage(mess.toString())
        .setPositiveButton("confirm" ,  null )
        .show();

        setContentView(R.layout.container);
        LinearLayout parent = (LinearLayout) findViewById(R.id.container);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView syncText = new TextView(this);
        syncText.setText("Synchronous message mode");
        syncText.setTextSize(20);
        parent.addView(syncText, params1);

        mXWalkView1 = new XWalkView(this, this);
        parent.addView(mXWalkView1, params);

        TextView asyncText = new TextView(this);
        asyncText.setText("Asynchronous message mode");
        asyncText.setTextSize(20);
        parent.addView(asyncText, params1);

        mXWalkView2 = new XWalkView(this, this);
        parent.addView(mXWalkView2, params);

        mExtension = new ExtensionEcho();

        mXWalkView1.load("file:///android_asset/echo_sync.html", null);
        mXWalkView2.load("file:///android_asset/echo_async.html", null);

    }
}
