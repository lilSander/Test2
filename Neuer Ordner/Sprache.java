package de.unibremen.swp.karteikartenapp.logic;

import de.unibremen.swp.karteikartenapp.model.Sprache;
import de.unibremen.swp.karteikartenapp.persistence.SpracheRepository;
import all;
/**
 * Klasse, welche sich um das Verwalten der Sprache in der Persistenz kümmert
 */
public class SpracheLogik {
    /**

     */

    /**
     * Konstruktor der Sprache-Logik
     */
    public SpracheLogic()
    {
        sp = new SpracheRepository();
        if(!sp.getSprache().isPresent())
        {
            sp.init("Deutsch");
        }
    }
//Hier muss noch was geändert werden.
    /**
     * Setzt die Sprache in der Datenbank
     * @param sprache die neue Sprache
     */
    public void setSprache(String sprache)
    {
        sp.update(sprache);
    }

    /**
     * Liefert die aktuelle Sprache zurück
     * @return aktuelle Sprache
     * @throws IllegalArgumentException falls keine Sprache vorhanden
     */
    public String getSprache()
    {
        if(sp.getSprache().isPresent())
        {
            return sp.getSprache().get().getSprache();
        }
        else
        {
            throw new IllegalArgumentException("Sprache ist nicht vorhanden!");
        }
    }
}
