package com.example.gemery.groupradioaddfragment;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.gemery.groupradioaddfragment.bean.Student;
import com.example.gemery.groupradioaddfragment.bean.StudentA;
import com.google.gson.Gson;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Ignore
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.gemery.groupradioaddfragment", appContext.getPackageName());
    }
    //json 中嵌套json  {"name":"mrxi","age":"24","gender":1,"school":"bupt","grade":{"course":"English","score":100,"level":"A"}}
    @Ignore
    public void testGson(){
        String json = "{\"name\":\"mrxi\",\"age\":\"24\",\"gender\":1,\"school\":\"bupt\",\"grade\":{\"course\":\"English\",\"score\":100,\"level\":\"A\"}}";
        Gson gson = new Gson();

        Student student = gson.fromJson(json,Student.class);
        Log.e("tage",student.toString());

    }
    //json 中嵌套jsonArray  {"name":"mrxi","age":"24","gender":1,"school":"bupt",
    // "grade":[{"course":"English","score":100,"level":"A"},{"course":"Math","score":90,"level":"A"}]}
    @Test
    public void testGsonArray(){
        String json = "{\"name\":\"mrxi\",\"age\":\"24\",\"gender\":1,\"school\":\"bupt\",\"grade\":[{\"course\":\"English\",\"score\":100,\"level\":\"A\"},{\"course\":\"Math\",\"score\":90,\"level\":\"A\"}]}";


        Gson gson = new Gson();

        StudentA studentA = gson.fromJson(json,StudentA.class);

        Log.e("tage",studentA.toString());
    }
}
