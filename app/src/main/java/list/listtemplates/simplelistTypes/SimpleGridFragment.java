package list.listtemplates.simplelistTypes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import list.listtemplates.R;
import list.listtemplates.Utils.ListUtils;
import list.listtemplates.simpleListAdapters.SimpleGridListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SimpleGridFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleGridFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
private View simpleGridView = null;
    private RecyclerView simpleGridRecyclerView;

    public SimpleGridFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SimpleGridFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleGridFragment newInstance(String param1, String param2) {
        SimpleGridFragment fragment = new SimpleGridFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        simpleGridView =  inflater.inflate(R.layout.fragment_simple_grid, container, false);
        initToolBar();
        simpleGridRecyclerView = (RecyclerView) simpleGridView.findViewById(R.id.simplegridrecyclerview);

     //   initTooBar("GridList");
      //  simpleGridRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        simpleGridRecyclerView.setLayoutManager(layoutManager);

        List<SimpleGridDTO> androidVersions = ListUtils.getSimpleGridHorizontalData();
        SimpleGridListAdapter adapter = new SimpleGridListAdapter(getActivity(),androidVersions);
        simpleGridRecyclerView.setAdapter(adapter);
        return  simpleGridView;
    }
    private void initToolBar(){
        Toolbar mToolBar = (Toolbar)getActivity().findViewById(R.id.app_toolbar);
        TextView toolBarTitle = (TextView)mToolBar.findViewById(R.id.title);
        toolBarTitle.setText("SimpleGridList");

    }



}
