package sn.dev.projetimmo.dao;

import java.util.List;

public interface IImmeubleDao {
    public Immeuble save(Immeuble immeuble);
    public List<Immeuble> getImmeubleByMC(String mc);
    public Immeuble getImmeubleById(int id);
    public int update(Immeuble immeuble);

    public int delete(int id);

}
