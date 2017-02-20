package com.veryworks.android.lambda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        EditText et = (EditText) findViewById(R.id.textView);

        // 람다를 사용하는 이유
        // 1. 코드량을 줄일 수 있다

        // 람다 사용조건
        // 1. 콜백 객체가 인자로 넘어가는 곳
        // 2. 콜백 객체에 함수가 하나여야 한다

        // 람다 작성법
        //        ( Parameters ) -> { code }
        // 1. 콜백객체에서 하나의 함수에 있는 로직블럭만 사용된다.
        // 2. 함수명은 생략하고 괄호와 인자(타입생략)만 표시한다
        // 3. 함수명과 로직블럭을 -> 표시로 연결한다

        btn.setOnClickListener(
                //(Parameters) -> { Code }

                // 원형 :
                // public void onClick(View view){
                //     System.out.println(view);
                // }
                // 람다 1: 함수명 생략
                // (View view) -> { System.out.println(view); }
                // 람다 2: 함수 인자타입 생략
                // (view) -> { System.out.println(view); }
                // 람다 3: 인자가 하나일 경우 함수 괄호 생략
                // view -> { System.out.println(view); }
                // 람다 4: 한줄일경우 코드 괄호 생략, 세미콜론 생략
                // view -> System.out.println(view)
                // 람다 5 : 코드측 함수가 받는 인자가 하나일 경우 참조형 메소드로 작성
                //          전체 생략
                System.out::println
        );


        Button btnLoop = (Button) findViewById(R.id.btnLoop);
        Button btnStream = (Button) findViewById(R.id.btnStream);

        String objectArray[] = {"A","B","C","DX","E","F","G","H","I","J","K"};

        btnLoop.setOnClickListener(
                (v) -> {
                    // 반복문으로 데이터를 처리한다
                    // 데이터를 모두 읽은 후에만 처리할 수 있다
                    for (String str : objectArray) {
                        if (str.length( ) == 1) {
                            System.out.println("I am "+str);
                        }
                    }
                }
        );

        btnStream.setOnClickListener(
                (v) -> {
                    // 스트림을 이용해서 내부 반복으로 데이터를 처리한다.
                    // 데이터를 읽어들이면서 동시에 처리할 수 있다
                    Stream<String> stream = Arrays.stream(objectArray);
                    stream.filter(a->a.length()==1)
                            .forEach(a->System.out.println(a));
                }
        );


    }

    public void runLambdaFunction(){
        ClickListner arg =  calc(); // calc 가 호출되면 calc 함수에 정의된 람다식이 넘어온다.
        int result = arg.sum(50, 30);
        System.out.println("result:"+result);
    }

    public ClickListner calc() {
        return (value1, value2) -> {return value1 + value2;};
    }

    interface ClickListner {
        public abstract int sum(int value, int value2);
    }


    /* 하나의 함수 instance 로 작성
    /* 함수를 개체화 한다
    함수이름 생략 / (파라미터타입 생략 ) -> {
        실행블럭
    }
    */
}




