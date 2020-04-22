package kd.mission2.service;

import kd.mission2.model.Songs;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SongService {
    public List<Songs> songs;
    public SongService(){
        setSongs();
    }
    private void setSongs(){
        songs = new ArrayList<>();
        songs.add(new Songs(
                1,
                "A",
                "AA",
                "2010"));
        songs.add(new Songs(
                2,
                "B",
                "BB",
                "2019"));
        songs.add(new Songs(
                3,
                "C",
                "CC",
                "2018"));
    }
    public List<Songs> getAllSongs(){

        return songs;
    }
    public String addNewSong(Songs song) {
        if (Objects.isNull(song.getSongId())||Objects.isNull(song.getSongName()) || Objects.isNull(song.getSongArtist()) || Objects.isNull(song.getSongName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is some missing information");
        }

        songs.add(song);
        return "Add song success";
    }
    public String updateSong(Songs newSongInfo){
        for (Songs song: songs)
        if (song.getSongId() == newSongInfo.getSongId()){
            song.setSongName(newSongInfo.getSongName());
            song.setSongArtist(newSongInfo.getSongArtist());
            song.setSongYear(newSongInfo.getSongYear());
            return "Updated information of Song ID: " + newSongInfo.getSongId() + " successfully.";
        }
        return "Updated information of Song ID: " + newSongInfo.getSongId() + " failed.";
    }
    public String deleteSong(Integer songId){
        for (int index=0; index<songs.size(); index++){
            if (songs.get(index).getSongId() == songId){
                songs.remove(index);
                return "Remove Song ID " + songId + " successfully.";
            }
        }
        return "Remove Song ID " + songId + " failed.";
    }
}
