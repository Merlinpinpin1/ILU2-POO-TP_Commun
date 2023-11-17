package model;


public class CalendrierAnnuel {
	public Mois[] calendrier ;

	public CalendrierAnnuel()
	{
		this.calendrier = new Mois[12];
		calendrier[0]= new Mois("Janvier",31);
		calendrier[1]= new Mois("Février",28);
		calendrier[2]= new Mois("Mars",31);
		calendrier[3]= new Mois("Avril",30);
		calendrier[4]= new Mois("Mai",31);
		calendrier[5]= new Mois("Juin",30);
		calendrier[6]= new Mois("Juillet",31);
		calendrier[7]= new Mois("Août",31);
		calendrier[8]= new Mois("Septembre",30);
		calendrier[9]= new Mois("Octobre",31);
		calendrier[10]= new Mois("Novembre",30);
		calendrier[11]= new Mois("Décembre",31);
	}
	public boolean estLibre(int jours , int Mois)
	{
		if (Mois >= 1 && Mois <= 12)
		{
			return calendrier[Mois-1].estLibre(jours);
		}
		return false;
	}
	public boolean reserver(int jours , int Mois) {
		if (estLibre(jours,Mois))
		{
			calendrier[Mois-1].reserver(jours);
			return true;
		}
		return false;
	}
	  class Mois {
			private boolean[] jours ;
			private String nom ;
			
		public Mois(String nom , int nbjours){
			  this.nom = nom;
	           this.jours = new boolean[nbjours];
			for (int i = 0 ; i<nbjours ; i++)
			{
				jours[i]=false ;
			}
		}
		
	    public boolean estLibre(int jour) {
	        if (jour >= 1 && jour <= jours.length) {
	            return !jours[jour - 1]; 
	        } else {
	            throw new IllegalArgumentException("Jour invalide");
	        }
	    }

	    public void reserver(int jour) {
	        if (estLibre(jour)) {
	            jours[jour - 1] = true; 
	        } else {
	            throw new IllegalStateException("Le jour est déjà réservé");
	        }
	    }
}
}
