package simplesearching;

import java.util.Objects;

/**
 *
 * @author spangsberg
 */
public class ComputerGame implements Comparable<ComputerGame> {

    @Override
    public int compareTo(ComputerGame other) {
        return this.title.compareTo(other.title);
    }

    

    private String title;
    private String genre;

    
    /**
     * 
     * @param title
     * @param genre 
     */
    public ComputerGame(String title, String genre) {
        this.title = title;
        //this.genre = genre;
    }

    
    /**
     * 
     * @return 
     */
    public String getTitle() {
        return title;
    }

    
    /**
     * 
     * @return 
     */
    public String getGenre() {
        return genre;
    }

    
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "ComputerGame{" + "title=" + title + ", genre=" + genre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComputerGame other = (ComputerGame) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        return true;
    }

    
    
    

    
  
}
