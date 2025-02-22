package esprit.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/candidats")
@RestController
public class CandidatRestApi {

    private String title="Hello From MS CANDIDAT";

@RequestMapping("/hello")
    public String sayHello()
    {return title;}

    @Autowired
    private ICandidatService iCandidatService;
@RequestMapping
public ResponseEntity<List<Candidat>> getAll()
{
  return new ResponseEntity<List<Candidat>>
          (iCandidatService.getAll(), HttpStatus.OK);
}
    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) { return new ResponseEntity<>(iCandidatService.addCandidat(candidat), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Candidat> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Candidat candidat){ return new ResponseEntity<>(iCandidatService.updateCandidat(id, candidat),
            HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){ return new ResponseEntity<>(iCandidatService.deleteCandidat(id), HttpStatus.OK);
    }


}
