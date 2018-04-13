package com.test.vinove.jsontest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    SpecialistModel specialistModel;
    ArrayList<SpecialistModel> list;

    @BindView(R.id.recyclerView_id)
    RecyclerView rview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager lManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        rview.setLayoutManager(lManager);

        list = new ArrayList<>();
        Log.d("Hello", "Android");
        getAllInsuranceList();
      /*  try {
            JSONObject jsonObject = new JSONObject("{\"code\":200,\"specialities\":[{\"id\":1,\"name\":\"Acupuncturist\",\"name_ar\":\"\\u0627\\u0644\\u0648\\u062e\\u0632 \\u0628\\u0627\\u0644\\u0623\\u0628\\u0631\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":2,\"name\":\"Allergists\",\"name_ar\":\"\\u0627\\u0644\\u062d\\u0633\\u0627\\u0633\\u064a\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":3,\"name\":\"Audiologists\",\"name_ar\":\"\\u0627\\u0644\\u0633\\u0645\\u0639\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":4,\"name\":\"Cardiologists\",\"name_ar\":\"\\u0627\\u0644\\u0642\\u0644\\u0628\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":5,\"name\":\"Chiropractors\",\"name_ar\":\"\\u0627\\u0644\\u0623\\u0633\\u0646\\u0627\\u0646\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":6,\"name\":\"Dentists\",\"name_ar\":\"\\u062a\\u0642\\u0648\\u064a\\u0645 \\u0627\\u0644\\u0623\\u0633\\u0646\\u0627\\u0646\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":7,\"name\":\"Dermatologists\",\"name_ar\":\"\\u062c\\u0631\\u0627\\u062d\\u0629 \\u0627\\u0644\\u0623\\u0633\\u0646\\u0627\\u0646\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":8,\"name\":\"Dietitians\",\"name_ar\":\"\\u0627\\u0644\\u062c\\u0644\\u062f\\u064a\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":9,\"name\":\"Ear. Nose & Throat Doctors\",\"name_ar\":\"\\u0623\\u0646\\u0641 \\u0648\\u0623\\u0630\\u0646 \\u0648\\u062d\\u0646\\u062c\\u0631\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":10,\"name\":\"Emergency Medicine Physicians\",\"name_ar\":\"\\u0627\\u0644\\u062a\\u063a\\u0630\\u064a\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":11,\"name\":\"Endocrinologists\",\"name_ar\":\"\\u0627\\u0644\\u0633\\u0643\\u0631\\u064a \\u0648\\u0627\\u0644\\u063a\\u062f\\u062f \\u0627\\u0644\\u0635\\u0645\\u0627\\u0621\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":12,\"name\":\"Endodontists\",\"name_ar\":\"\\u0627\\u0644\\u0639\\u064a\\u0648\\u0646\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":13,\"name\":\"Eye Doctors\",\"name_ar\":\"\\u0637\\u0628 \\u0627\\u0644\\u0623\\u0633\\u0631\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":14,\"name\":\"Family Phsicians\",\"name_ar\":\"\\u0627\\u0644\\u0628\\u0627\\u0637\\u0646\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":15,\"name\":\"Gastroenterologists\",\"name_ar\":\"\\u0627\\u0644\\u0631\\u0626\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":16,\"name\":\"Hand Surgeons\",\"name_ar\":\"\\u0627\\u0644\\u062c\\u0647\\u0627\\u0632 \\u0627\\u0644\\u0647\\u0636\\u0645\\u064a\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":17,\"name\":\"Hearing Specialists\",\"name_ar\":\"\\u0627\\u0644\\u0623\\u0645\\u0631\\u0627\\u0636 \\u0627\\u0644\\u0645\\u0639\\u062f\\u064a\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":18,\"name\":\"Hematologists\",\"name_ar\":\"\\u0627\\u0644\\u0639\\u0642\\u0645\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":19,\"name\":\"Infectious Disease Specialists\",\"name_ar\":\"\\u0627\\u0644\\u0643\\u0644\\u0649 \",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":20,\"name\":\"Infertility Specialists\",\"name_ar\":\"\\u0627\\u0644\\u0645\\u062e \\u0648\\u0627\\u0644\\u0623\\u0639\\u0635\\u0627\\u0628\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":21,\"name\":\"Internists\",\"name_ar\":\"\\u0627\\u0644\\u0646\\u0633\\u0627\\u0621 \\u0648\\u0627\\u0644\\u0648\\u0644\\u0627\\u062f\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":22,\"name\":\"Naturopathic Doctors\",\"name_ar\":\"\\u0627\\u0644\\u0623\\u0648\\u0631\\u0627\\u0645\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":23,\"name\":\"Nephrologists\",\"name_ar\":\"\\u0627\\u0644\\u062c\\u0631\\u0627\\u062d\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":24,\"name\":\"Neurologists\",\"name_ar\":\"\\u0627\\u0644\\u0623\\u0637\\u0641\\u0627\\u0644\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":25,\"name\":\"Neurosurgeons\",\"name_ar\":\"\\u0639\\u0644\\u0627\\u062c \\u0637\\u0628\\u064a\\u0639\\u064a\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":26,\"name\":\"Nurse Practitioners\",\"name_ar\":\"\\u0627\\u0644\\u062a\\u062c\\u0645\\u064a\\u0644\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":27,\"name\":\"Nutritionists\",\"name_ar\":\"\\u0627\\u0644\\u0642\\u062f\\u0645\\u064a\\u0646\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":28,\"name\":\"OB-GYNs\",\"name_ar\":\"\\u0627\\u0644\\u0637\\u0628 \\u0627\\u0644\\u0646\\u0641\\u0633\\u064a\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":29,\"name\":\"Oncologists\",\"name_ar\":\"\\u0627\\u0644\\u0623\\u0634\\u0639\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":30,\"name\":\"Ophthalmologists\",\"name_ar\":\"\\u0623\\u062e\\u0635\\u0627\\u0626\\u064a \\u0627\\u0644\\u062a\\u062e\\u062f\\u064a\\u0631\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":31,\"name\":\"Optometrists\",\"name_ar\":\"\\u0627\\u0644\\u0623\\u0635\\u0627\\u0628\\u0627\\u062a \\u0627\\u0644\\u0631\\u064a\\u0627\\u0636\\u064a\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":32,\"name\":\"Oral Surgeons\",\"name_ar\":\"\\u0627\\u0644\\u0631\\u0648\\u0645\\u0627\\u062a\\u064a\\u0632\\u0645\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":33,\"name\":\"Orthodontists\",\"name_ar\":\"\\u0627\\u0644\\u0645\\u0633\\u0627\\u0644\\u0643 \\u0627\\u0644\\u0628\\u0648\\u0644\\u064a\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":34,\"name\":\"Orthopedic Surgeons\",\"name_ar\":\"\\u0623\\u0645\\u0631\\u0627\\u0636 \\u0627\\u0644\\u0634\\u064a\\u062e\\u0648\\u062e\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":35,\"name\":\"Pain Management Specialists\",\"name_ar\":\"\\u0623\\u0645\\u0631\\u0627\\u0636 \\u0627\\u0644\\u062f\\u0645\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":36,\"name\":\"Pediatric Dentists\",\"name_ar\":\"\\u0627\\u0644\\u0623\\u0648\\u0639\\u064a\\u0629 \\u0627\\u0644\\u062f\\u0645\\u0648\\u064a\\u0629\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":37,\"name\":\"Pediatric Urgent Care Speialists\",\"name_ar\":\"\\u0637\\u0628\\u064a\\u0628 \\u0639\\u0627\\u0645\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":38,\"name\":\"Pediatricians\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":39,\"name\":\"Periodontists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":40,\"name\":\"Physiatrists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":41,\"name\":\"Physical Therapists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":42,\"name\":\"Plastic Surgeons\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":43,\"name\":\"Podiatrists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":44,\"name\":\"Doctors\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":45,\"name\":\"Prosthodontists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":46,\"name\":\"Psychiatrists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":47,\"name\":\"Psychologists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":48,\"name\":\"Psychotherapists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":49,\"name\":\"Pulmonologists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":50,\"name\":\"Radiologists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":51,\"name\":\"Rheumatologists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":52,\"name\":\"Sleep Medicine Specialists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":53,\"name\":\"Sports Medicicne Specialists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":54,\"name\":\"Surgeons\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":55,\"name\":\"Therapists  \\/ Counselors\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":56,\"name\":\"Urgent Care Specialists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null},{\"id\":57,\"name\":\"Urologists\",\"name_ar\":\"\",\"is_active\":1,\"created_at\":null,\"updated_at\":null}]}");

        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        login("test@test.com", "1234567!");
    }

    private void login(String id, String pass) {
        RozenamahApi rozenamahApi = ApiClient.getClient().create(RozenamahApi.class);
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", id);
            jsonObject.put("password", pass);

            Call<JsonElement> call = rozenamahApi.loginApi(jsonObject);

            //it is hitting ws url
            call.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(@NonNull Call<JsonElement> call,
                                       @NonNull Response<JsonElement> response) {

                }

                @Override
                public void onFailure(@NonNull Call<JsonElement> call, @NonNull Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void getAllInsuranceList() {
        RozenamahApi rozenamahApi = ApiClient.getClient().create(RozenamahApi.class);
        try {

            Call<JsonElement> call = rozenamahApi.specialityListApi("", "en", "1");

            //it is hitting ws url
            call.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(@NonNull Call<JsonElement> call,
                                       @NonNull Response<JsonElement> response) {

                    try {
                        JSONObject jsonObject = new JSONObject(response.body().toString());

                        String code = jsonObject.optString("code");
                        Log.e("code", code);

                        JSONArray specialitiesArr = jsonObject.optJSONArray("specialities");
                        for (int i = 0; i < specialitiesArr.length(); i++) {

                            JSONObject insuranceObj = specialitiesArr.optJSONObject(i);

                            String id = insuranceObj.optString("id");
                            String name = insuranceObj.optString("name");
                            String name_ar = insuranceObj.optString("name_ar");
                            String is_active = insuranceObj.optString("is_active");

                            specialistModel = new SpecialistModel(id, name, name_ar, is_active);
                            list.add(specialistModel);
                        }

                        MyAdapter myAdapter = new MyAdapter(MainActivity.this, list);
                        rview.setAdapter(myAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<JsonElement> call, @NonNull Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
