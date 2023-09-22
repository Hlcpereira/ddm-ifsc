package com.example.tarefa8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview_apps);

        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> packageInfoList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> appList = packageManager.queryIntentActivities(mainIntent, 0);

        AppAdapter appAdapter = new AppAdapter(this,R.layout.item_app_list, packageInfoList);
        listView.setAdapter(appAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ApplicationInfo applicationInfo = (ApplicationInfo) parent.getItemAtPosition(position);
                String packageName = applicationInfo.packageName;
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

                Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Não foi possível abrir o aplicativo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        (R.id.frameLayout);
    }
}