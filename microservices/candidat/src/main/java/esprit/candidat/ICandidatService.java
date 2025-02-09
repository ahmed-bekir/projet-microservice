package esprit.candidat;

import java.util.List;

public interface ICandidatService {
    public List<Candidat> getAll();

    public Candidat addCandidat(Candidat c);

    public Candidat updateCandidat(int id, Candidat newCandidat)
        ;
    public String deleteCandidat(int id);
}
