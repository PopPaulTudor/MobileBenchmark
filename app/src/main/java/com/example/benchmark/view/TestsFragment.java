package com.example.benchmark.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.benchmark.R;
import com.example.benchmark.benchmark.BabylonianCPU;
import com.example.benchmark.benchmark.EncryptionCPU;
import com.example.benchmark.benchmark.FilesReadStorage;
import com.example.benchmark.benchmark.FilesWriteStorage;
import com.example.benchmark.benchmark.FloatOperationsCPU;
import com.example.benchmark.benchmark.IntegerOperationsCPU;
import com.example.benchmark.controller.TestManager;

public class TestsFragment extends Fragment {

    private TextView intInfo, babInfo, floatingInfo, encryptInfo,writeInfo, readInfo;
    private TextView intResults, babResults, floatingResults, encryptResults, writeResults, readResults;
    private Button intButton, babButton, floatingButton, encryptButton, writeButton, readButton ;
    private TestManager testManager;
    ProgressDialog progress;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tests, container, false);
        intInfo = root.findViewById(R.id.int_infoTest);
        floatingInfo = root.findViewById(R.id.float_infoTest);
        babInfo = root.findViewById(R.id.bab_infoTest);
        encryptInfo = root.findViewById(R.id.encrypt_infoTest);
        writeInfo = root.findViewById(R.id.file_w_infoTest);
        readInfo = root.findViewById(R.id.file_r_infoTest);

        intResults = root.findViewById(R.id.int_results_test);
        floatingResults = root.findViewById(R.id.float_results_test);
        babResults = root.findViewById(R.id.bab_results_test);
        encryptResults = root.findViewById(R.id.encrypt_results_test);
        writeResults = root.findViewById(R.id.file_w_results_test);
        readResults = root.findViewById(R.id.file_r_results_test);

        intButton = root.findViewById(R.id.integer_button);
        babButton = root.findViewById(R.id.babylonian_button);
        floatingButton = root.findViewById(R.id.float_button);
        encryptButton = root.findViewById(R.id.encrypt_button);
        writeButton = root.findViewById(R.id.file_w_button);
        readButton = root.findViewById(R.id.file_r_button);

        progress = new ProgressDialog(getActivity());
        progress.setTitle("Loading");
        progress.setMessage("Wait while testing...");
        progress.setCancelable(false);


        intInfo.setText("This test performs each basic operation on integers for 10.000.000 times. " +
                "The test is performed 5 times and the resulted time is saved in the result and calculated with a formula");

        babInfo.setText("This test approximates square roots using the Babylonian Method. " +
                "The test is performed 5 times and the resulted time is saved in the result and calculated with a formula");


        floatingInfo.setText("This test performs each basic operation on floating numbers for 10.000.000 times. " +
                "The test is performed 5 times and the resulted time is saved in the result and calculated with a formula");


        encryptInfo.setText("This test approximates square roots using the SHA-1 Encryption. " +
                "The test is performed 20.000 times and the resulted time is saved in the result " +
                "and calculated with a formula");

        writeInfo.setText("This test measures the speed of writing a 5 MB file in the internal storage.");
        readInfo.setText("This test measures the speed of reading a 5 MB file in the internal storage.");

        testManager = TestManager.getInstance(getActivity());

        intButton.setOnClickListener(v -> {
            progress.show();
            IntegerOperationsCPU integerCPU = new IntegerOperationsCPU();
            intResults.setText(String.format("Score: %s ms\nThe average time on performing 10.000.000 operations on natural numbers is %s ms.", integerCPU.getScore(), integerCPU.getScore()));

            progress.dismiss();

            testManager.addTest(integerCPU);
        });

        babButton.setOnClickListener(v -> {
            progress.show();
            BabylonianCPU babylonianCPU = new BabylonianCPU();
            floatingResults.setText(String.format("Score: %s ms\nThe average time on performing 10.000.000 operations on floating numbers is %s ms.", babylonianCPU.getScore(), babylonianCPU.getScore()));
            progress.dismiss();

            testManager.addTest(babylonianCPU);


        });

        floatingButton.setOnClickListener(v -> {
            progress.show();
            FloatOperationsCPU floatingCPU = new FloatOperationsCPU();
            babResults.setText(String.format("Score: %s ms\nThe average time on approximating the square roots of Pi and Euler's number is %s ms.", floatingCPU.getScore(), floatingCPU.getScore()));
            progress.dismiss();

            testManager.addTest(floatingCPU);


        });


        encryptButton.setOnClickListener(v -> {
            EncryptionCPU encryptionCPU = new EncryptionCPU();
            encryptResults.setText(String.format("Score: %s ms\nThe average time on encrypting the message Benchmark for Android is %s ms.", encryptionCPU.getScore(), encryptionCPU.getScore()));
            progress.dismiss();

            testManager.addTest(encryptionCPU);

        });

        readButton.setOnClickListener(v -> {
            FilesReadStorage filesReadStorage = new FilesReadStorage();
            readResults.setText(String.format("Score: %s ms\nThe average time on write 5 MB of information is %s ms.", filesReadStorage.getScore(), filesReadStorage.getScore()));
            progress.dismiss();

            testManager.addTest(filesReadStorage);

        });


        writeButton.setOnClickListener(v -> {
            FilesWriteStorage filesWriteStorage = new FilesWriteStorage();
            writeResults.setText(String.format("Score: %s ms\nThe average time on write 5 MB of information is %s ms.", filesWriteStorage.getScore(), filesWriteStorage.getScore()));
            progress.dismiss();

            testManager.addTest(filesWriteStorage);

        });

        return root;
    }



}