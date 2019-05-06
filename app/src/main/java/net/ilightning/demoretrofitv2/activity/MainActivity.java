package net.ilightning.demoretrofitv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import net.ilightning.demoretrofitv2.R;
import net.ilightning.demoretrofitv2.adpater.ChapterAdapter;
import net.ilightning.demoretrofitv2.api.RestManager;
import net.ilightning.demoretrofitv2.model.ChapterModel;
import net.ilightning.demoretrofitv2.model.ListDataChapterModel;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    + Bước 1: Import thư viện
//    + Bước 2: Phân tích link api từ file json trả về thành các đối tượng model tương ứng
//    + Bước 3: Cấu hình các class để sử dụng Retrofit
//    + Bước 4: Gọi thư viện ra sử dụng và lấy dữ liệu về
//    + Bước 5: Chuyển đổi dữ liệu trả về từ dạng String sang dạng Object Modelđê
//    + Bước 6: Hiển thị dữ liệu lên trên RecycleView
//  JSON Formatter  https://chrome.google.com/webstore/detail/json-formatter/bcjindcccaagfpapjjmafapmmgkkhgoa

    private RecyclerView rcChapter;
    private ChapterAdapter chapterAdapter;
    private ArrayList<ChapterModel> chapterModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.rcChapter = findViewById(R.id.rcChapter);

        this.chapterModels = new ArrayList<>();
        this.chapterAdapter = new ChapterAdapter(this, chapterModels);
        this.rcChapter.setHasFixedSize(true);
        this.rcChapter.setLayoutManager(new LinearLayoutManager(this));
        this.rcChapter.setAdapter(chapterAdapter);


        final Gson gson = new Gson();


        Call<ResponseBody> call = RestManager.getApi().getData();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("HoangTV", "isSuccessful()");
                    try {
                        String data = response.body().string();
                        ListDataChapterModel listDataChapterModel = gson.fromJson(data, ListDataChapterModel.class);
                        chapterModels = listDataChapterModel.getChapterModels();
                        for (ChapterModel model : chapterModels) {
                            Log.d("HoangTV", "Title: " + model.getTitle());
                        }
                        chapterAdapter.addListChapter(chapterModels);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.d("HoangTV", "false()");
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("HoangTV", "onFailure()");
            }
        });
    }
}
