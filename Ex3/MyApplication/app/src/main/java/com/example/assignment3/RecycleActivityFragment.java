package com.example.assignment3;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class RecycleActivityFragment extends Fragment {

    private RecyclerView recyclerViewer;
    private android.support.v7.widget.RecyclerView.Adapter adapter;

    private List<ListItem> starkList  = new ArrayList<>();
    private List<ListItem> lanisterList  = new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_recycle, container, false);

        recyclerViewer = (RecyclerView)mainView.findViewById(R.id.recycleView1);
        recyclerViewer.setHasFixedSize(true);
        recyclerViewer.setLayoutManager(new LinearLayoutManager(this.getContext()));
        buildHousesLists();

        if (MainActivityFragment.isLastwWantedStark) {
            adapter = new RecycleAdapter(starkList, this.getContext());
        }
        else {
            adapter = new RecycleAdapter(lanisterList, this.getContext());
        }

        recyclerViewer.setAdapter(adapter);

        return  mainView;
    }

    private void buildHousesLists() {
        starkList.add(new ListItem("Eddard",
                "Lord Eddard Stark, also known as Ned Stark, was the head of House Stark, " +
                        "the Lord of Winterfell, Lord Paramount and Warden of the North, " +
                        "and later Hand of the King to King Robert I Baratheon."));
        starkList.add(new ListItem("Catelyn","Catelyn Stark, née Tully," +
                " was born into House Tully as the daughter of Hoster Tully, " +
                "the Lord Paramount of the Trident, and sister of Lysa and Edmure Tully. S" +
                "he married into House Stark through her marriage to Eddard Stark,"));
        starkList.add(new ListItem("Robb","King Robb Stark was the eldest son of " +
                "Lord Eddard Stark of Winterfell and his wife, Lady Catelyn." ));
        starkList.add(new ListItem("Sansa", "Lady Sansa Stark is the eldest daughter of " +
                "Lord Eddard Stark of Winterfell and his wife Lady Catelyn"));
        starkList.add(new ListItem("Arya", "Arya Stark is the third child and second daughter of" +
                " Lord Eddard Stark and his wife, Lady Catelyn Stark."));
        starkList.add(new ListItem("Bran", "Brandon Stark, commonly called Bran," +
                " is the fourth child and second son of Eddard and Catelyn Stark." +
                " Bran is a warg and currently the new Three-Eyed Raven,"));
        starkList.add(new ListItem("Rickon", "Rickon is the fifth child and youngest son of " +
                "Lady Catelyn and Lord Eddard Stark."));
        starkList.add(new ListItem("Jon Sonw", "Jon Snow, born Aegon Targaryen," +
                " is the son of Lyanna Stark and Rhaegar Targaryen, the late Prince of Dragonstone. " +
                "From infancy, Jon is presented as the bastard son of Lord Eddard Stark, " +
                "Lyanna's brother, and raised by Eddard alongside his lawful children at Winterfe"));
        starkList.add(new ListItem("Benjen"," Benjen Stark was the First Ranger of the Night's Watch. " +
                "He embarks on a ranging north of the Wall, and did not return."));

        lanisterList.add(new ListItem("Tywin", "Tywin is the Lord of House Lannister, " +
                "the Lord Paramount of the Westerlands, and the richest man in the Seven Kingdoms." +
                " The Westerlands are one of the constituent regions of the" +
                " Seven Kingdoms and House Lannister is one of the Great Houses of the realm. " +
                "House Lannister rule the region from their seat of Casterly Rock and " +
                "Tywin also holds the title Lord of Casterly Rock. He is also the Warden of the West. "));
        lanisterList.add(new ListItem("Cersei", "Queen Cersei I Lannister is the widow of " +
                "King Robert Baratheon and Queen of the Seven Kingdoms." +
                " She is the daughter of Lord Tywin Lannister, twin sister of " +
                "Jaime Lannister and elder sister of Tyrion Lannister." +
                " She has an incestuous relationship with Jaime, " +
                "who is secretly the father of her three children, Joffrey, Myrcella and Tommen."));

        lanisterList.add(new ListItem("Jaime", "Ser Jaime Lannister is the eldest son of Tywin, " +
                "younger twin brother of Cersei, and older brother of Tyrion Lannister." +
                " He is involved in an incestuous relationship with Cersei, " +
                "and unknown to most, he is the biological " +
                "father of her three children, Joffrey, Myrcella, and Tommen."));

        lanisterList.add(new ListItem("Tyrion", "Lord Tyrion Lannister is the youngest child of " +
                "Lord Tywin Lannister and younger brother of Cersei and Jaime Lannister. " +
                "A dwarf, he uses his wit and intellect to overcome the prejudice he faces."));
    }
}
