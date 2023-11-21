package com.example.Library;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.notes.R;


public class BookFragment extends Fragment {
    private EditText title;
    private EditText author;
    private EditText genre;
    private EditText review;

    // TODO: Rename parameter arguments, choose names that match
    private String mParam1;
    private String mParam2;
    private OnFragmentSendDataListener fragmentSendDataListener;

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
    interface OnFragmentSendDataListener {
        void onSendTitle(String data);
        void onSendGenre(String data);
        void onSendReview(String data);
        void onSendAuthor(String data);
    }



    public BookFragment() {
        super(R.layout.fragment_book);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void updateTitle(String data) {
        // Обновление данных во фрагменте
        EditText text = getView().findViewById(R.id.Title);
        text.setText(data);
    }
    public void updateAuthor(String data) {
        // Обновление данных во фрагменте
        EditText text = getView().findViewById(R.id.Author);
        text.setText(data);
    }
    public void updateGenre(String data) {
        // Обновление данных во фрагменте
        EditText text = getView().findViewById(R.id.Genre);
        text.setText(data);
    }
    public void updateReview(String data) {
        // Обновление данных во фрагменте
        EditText text = getView().findViewById(R.id.Review);
        text.setText(data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Получение данных из Bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            Book selectedBook = (Book) bundle.getSerializable("selectedBook");
            // Использование данных для отображения во фрагменте
        }
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        // Установка ссылок на EditText-элементы
        title = view.findViewById(R.id.Title);
        author = view.findViewById(R.id.Author);
        genre = view.findViewById(R.id.Genre);
        review = view.findViewById(R.id.Review);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Остальной код вашего метода onViewCreated

        Button saveButton = view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleText = title.getText().toString(); // Получение текста из элемента EditText
                String authorText = author.getText().toString(); // Аналогично для других элементов
                String genreText = genre.getText().toString();
                String reviewText = review.getText().toString();

                fragmentSendDataListener.onSendTitle(titleText);
                fragmentSendDataListener.onSendAuthor(authorText);
                fragmentSendDataListener.onSendGenre(genreText);
                fragmentSendDataListener.onSendReview(reviewText);
            }
        });
    }
}
