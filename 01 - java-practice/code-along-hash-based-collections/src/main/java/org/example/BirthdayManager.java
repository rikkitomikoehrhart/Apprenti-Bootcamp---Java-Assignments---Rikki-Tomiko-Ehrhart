package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class BirthdayManager {
    private HashMap<Friend, List<Gift>> myFriendsGifts;

    public BirthdayManager() {
        this.myFriendsGifts = new HashMap<Friend, List<Gift>>();
    }


    public List<Friend> getFriends() {
        return myFriendsGifts.keySet().stream().toList();
    }

    public void addFriend(Friend newFriend) {
        myFriendsGifts.put(newFriend, new ArrayList<Gift>());
    }

    public void addGift(Friend friend, Gift gift) {
        myFriendsGifts.get(friend).add(gift);
        System.out.println(myFriendsGifts.get(friend));
    }

    public void removeFriend(Friend exFriend) {
        myFriendsGifts.remove(exFriend);
    }
}
