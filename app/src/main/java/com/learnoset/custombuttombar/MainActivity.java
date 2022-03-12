package com.learnoset.custombuttombar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // number of selected tab. we have 4 tabs so value must lie between 1-4. default value is 1 because first tab is selected by default.
    private int selectedTab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout homeLayout = findViewById(R.id.homeLayout);
        final LinearLayout likeLayout = findViewById(R.id.likeLayout);
        final LinearLayout notificationLayout = findViewById(R.id.notificationLayout);
        final LinearLayout profileLayout = findViewById(R.id.profileLayout);

        final ImageView homeImage = findViewById(R.id.homeImage);
        final ImageView likeImage = findViewById(R.id.likeImage);
        final ImageView notificationImage = findViewById(R.id.notificationImage);
        final ImageView profileImage = findViewById(R.id.profileImage);

        final TextView homeTxt = findViewById(R.id.homeTxt);
        final TextView likeTxt = findViewById(R.id.likeTxt);
        final TextView notificationTxt = findViewById(R.id.notificationTxt);
        final TextView profileTxt = findViewById(R.id.profileTxt);


        // set home fragment by default
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, HomeFragment.class, null)
                .commit();

        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check if home is already selected or not.
                if(selectedTab != 1){

                    // set home fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, HomeFragment.class, null)
                            .commit();

                    // unselect other tabs expect home tab
                    likeTxt.setVisibility(View.GONE);
                    notificationTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    likeImage.setImageResource(R.drawable.like_icon);
                    notificationImage.setImageResource(R.drawable.notification_icon);
                    profileImage.setImageResource(R.drawable.profile_icon);

                    likeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select home tab
                    homeTxt.setVisibility(View.VISIBLE);
                    homeImage.setImageResource(R.drawable.home_selected_icon);
                    homeLayout.setBackgroundResource(R.drawable.round_back_home_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    homeLayout.startAnimation(scaleAnimation);

                    // set 1st tab as selected tab
                    selectedTab = 1;
                }
            }
        });

        likeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check if like tab is already selected or not.
                if(selectedTab != 2){

                    // set like fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, LikesFragments.class, null)
                            .commit();

                    // unselect other tabs expect like tab
                    homeTxt.setVisibility(View.GONE);
                    notificationTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home_icon);
                    notificationImage.setImageResource(R.drawable.notification_icon);
                    profileImage.setImageResource(R.drawable.profile_icon);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select home tab
                    likeTxt.setVisibility(View.VISIBLE);
                    likeImage.setImageResource(R.drawable.like_selected_icon);
                    likeLayout.setBackgroundResource(R.drawable.round_back_like_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    likeLayout.startAnimation(scaleAnimation);

                    // set 2st tab as selected tab
                    selectedTab = 2;
                }
            }
        });

        notificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check if notification tab is already selected or not.
                if(selectedTab != 3){

                    // set notification fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, NotificationFragment.class, null)
                            .commit();

                    // unselect other tabs expect notification tab
                    homeTxt.setVisibility(View.GONE);
                    likeTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home_icon);
                    likeImage.setImageResource(R.drawable.like_icon);
                    profileImage.setImageResource(R.drawable.profile_icon);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    likeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select home tab
                    notificationTxt.setVisibility(View.VISIBLE);
                    notificationImage.setImageResource(R.drawable.notification_selected_icon);
                    notificationLayout.setBackgroundResource(R.drawable.round_back_notification_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    notificationLayout.startAnimation(scaleAnimation);

                    // set 3rd tab as selected tab
                    selectedTab = 3;
                }

            }
        });

        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check if profile tab is already selected or not.
                if(selectedTab != 4){

                    // set profile fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, ProfileFragment.class, null)
                            .commit();

                    // unselect other tabs expect profile tab
                    homeTxt.setVisibility(View.GONE);
                    likeTxt.setVisibility(View.GONE);
                    notificationTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home_icon);
                    likeImage.setImageResource(R.drawable.like_icon);
                    notificationImage.setImageResource(R.drawable.notification_icon);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    likeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select home tab
                    profileTxt.setVisibility(View.VISIBLE);
                    profileImage.setImageResource(R.drawable.profile_selected_icon);
                    profileLayout.setBackgroundResource(R.drawable.round_back_profile_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    profileLayout.startAnimation(scaleAnimation);

                    // set 4th tab as selected tab
                    selectedTab = 4;
                }
            }
        });

    }
}