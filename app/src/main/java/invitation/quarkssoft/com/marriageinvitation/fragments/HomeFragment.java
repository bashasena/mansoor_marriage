package invitation.quarkssoft.com.marriageinvitation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;


import invitation.quarkssoft.com.marriageinvitation.R;
import invitation.quarkssoft.com.marriageinvitation.constansts.NavigationDrawerConstants;


public class HomeFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getActivity().setTitle(NavigationDrawerConstants.TAG_HOME_TITLE);
        //getActivity().getActionBar().hide();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
