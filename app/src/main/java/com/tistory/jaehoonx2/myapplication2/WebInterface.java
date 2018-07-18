package com.tistory.jaehoonx2.myapplication2;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebInterface {
    Context context;

    public WebInterface() {}

    public WebInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface        // annotation 필수 - 웹에서 콜이 된다는 얘기임
    public void displayToast(int index){
        String msg = "";
        if(index == 1){
            msg = "블루베리는 몸에 좋다.";
        } else if(index == 2){
            msg = "오렌지는 몸에 좋다.";
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    //웹에서 나를 호출할 때 쓰는 메서드 제작

}
