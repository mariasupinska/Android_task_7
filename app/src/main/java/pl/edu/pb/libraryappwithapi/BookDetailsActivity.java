package pl.edu.pb.libraryappwithapi;

import static pl.edu.pb.libraryappwithapi.MainActivity.IMAGE_URL_BASE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookDetailsActivity extends AppCompatActivity {
    public final static String EXTRA_BOOK_OBJ = "EXTRA_BOOK_OBJ";

    private TextView bookTitleTextView;
    private TextView bookAuthorTextView;
    private TextView numberOfPagesTextView;
    private ImageView bookCover;
    private TextView bookYearOfPublishingTextView;
    private TextView bookPublishersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        bookTitleTextView = findViewById(R.id.book_title);
        bookAuthorTextView = findViewById(R.id.book_author);
        numberOfPagesTextView = findViewById(R.id.number_of_pages);
        bookCover = findViewById(R.id.img_cover);
        bookYearOfPublishingTextView = findViewById(R.id.book_year_of_publishing);
        bookPublishersTextView = findViewById(R.id.book_publishers);

        Book book = (Book) getIntent().getSerializableExtra(EXTRA_BOOK_OBJ);

        bookTitleTextView.setText(getString(R.string.title) + book.getTitle());
        bookAuthorTextView.setText(getString(R.string.author) + TextUtils.join(", ", book.getAuthors()));
        numberOfPagesTextView.setText(getString(R.string.number_of_pages) + book.getNumberOfPages());
        bookYearOfPublishingTextView.setText(getString(R.string.year_of_publishing) + String.valueOf(book.getYearOfPublishing()));
        bookPublishersTextView.setText(getString(R.string.publishers) + TextUtils.join(", ", book.getPublishers()));

        if (book.getCover() != null) {
            Picasso.with(getApplicationContext())
                    .load(IMAGE_URL_BASE + book.getCover() + "-L.jpg")
                    .placeholder(R.drawable.ic_baseline_book).into(bookCover);
        } else {
            bookCover.setImageResource(R.drawable.ic_baseline_book);
        }
    }
}