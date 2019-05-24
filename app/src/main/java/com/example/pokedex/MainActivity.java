package com.example.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.algolia.instantsearch.helpers.InstantSearch;
import com.algolia.instantsearch.helpers.Searcher;
import com.algolia.search.saas.Client;
import com.algolia.search.saas.Index;
import com.example.pokedex.R;

public class MainActivity extends AppCompatActivity {
    Searcher searcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String ALGOLIA_APP_ID="9QJIKJ8ZVS";
        String ALGOLIA_SEARCH_API_KEY="6e05f32fb13128f68bde9160fbcb6203";
        String ALGOLIA_INDEX_NAME="pokedex";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Searcher searcher = Searcher.create(ALGOLIA_APP_ID, ALGOLIA_SEARCH_API_KEY, ALGOLIA_INDEX_NAME);
        InstantSearch helper = new InstantSearch(this, searcher);
        helper.search();
    }

    @Override
    protected void onDestroy() {
        searcher.destroy();
        super.onDestroy();
    }
}