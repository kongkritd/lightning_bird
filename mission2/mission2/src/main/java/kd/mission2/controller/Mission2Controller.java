package kd.mission2.controller;

import kd.mission2.service.SongService;
import kd.mission2.model.Songs;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/songs")
public class Mission2Controller {
    private SongService songService;
    public Mission2Controller (SongService songService){
        this.songService = songService;
    }
    @GetMapping("/all-songs")
    public List<Songs> getAllSongs(){
        return songService.getAllSongs();
    }
    @PostMapping("/add-song")
    public String addNewSong(@RequestBody Songs song){
        return songService.addNewSong(song);
    }
    @PutMapping("/update-song")
    public String updateSong(@RequestBody Songs song){
        return songService.updateSong(song);
    }
    @DeleteMapping("/delete/{songId}")
    public String deleteSong(@PathVariable("songId")Integer songId) {
        return songService.deleteSong(songId);
    }

}
