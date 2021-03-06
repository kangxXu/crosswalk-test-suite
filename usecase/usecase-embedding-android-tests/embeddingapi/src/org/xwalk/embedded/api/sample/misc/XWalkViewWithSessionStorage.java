// Copyright (c) 2014 Intel Corporation. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.xwalk.embedded.api.sample.misc;

import org.xwalk.embedded.api.sample.R;

import org.xwalk.core.XWalkActivity;
import org.xwalk.core.XWalkView;

import android.app.AlertDialog;
import android.os.Bundle;


public class XWalkViewWithSessionStorage extends XWalkActivity {
    private XWalkView mXWalkView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xwalk_view_with_session_storage);
        mXWalkView = (XWalkView) findViewById(R.id.xwalk_view);
    }

    @Override
    protected void onXWalkReady() {
        StringBuffer mess = new StringBuffer();
        mess.append("Test Purpose: \n\n")
        .append("Verifies XWalkView can restore html5 sessionStorage value when screen rotates.\n\n")
        .append("Test  Step:\n")
        .append("1. Turn on android system auto rotate setting.\n")
        .append("2. Load the page and you get 'myname: null'.\n")
        .append("3. Rotate the screen.\n")
        .append("4. The 'myname: ' value should be changed to 'jack'.\n")
        .append("Expected Result:\n\n")
        .append("Test passes if sessionStorage value changed to 'jack' when screen rotates.");
        new  AlertDialog.Builder(this)
        .setTitle("Info" )
        .setMessage(mess.toString())
        .setPositiveButton("confirm" ,  null )
        .show();

        mXWalkView.load("file:///android_asset/session_storage_test.html", null);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        if (mXWalkView != null) {
            mXWalkView.restoreState(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        if (mXWalkView != null) {
            mXWalkView.saveState(outState);
        }
    }
}