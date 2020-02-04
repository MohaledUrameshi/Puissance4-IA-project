package up.mi.ken;

public class Grille {
	private static int[][] grille =new int[7][7];

	/**
	 * Constructeur qui initialise la ligne et la colonne � 7
	 */
	public Grille() {
	
	}
	/**
	 * met tout � zero
	 */
	public static void initialiserGrille() {
		for(int i=0;i<7;i++)
			for(int j=0;j<7;j++)
				grille[i][j]=0;
	}

	private static void afficherNumColonnes() {

		for (int i = 1; i <= 7; i++) {
			System.out.print("  " + i + " ");
		}
	}

	/**
	 * m�thode retournant une r�f de cette grille
	 * 
	 * @return la grille
	 */
	public static int[][] getGrille() {
		return grille;
	}

	/**
	 * cette m�thode affiche l'etat courant de la grille
	 */
	public static void afficherGrille() {
		afficherNumColonnes();
		System.out.println();

		for (int i = 0; i < 7; i++) {
			System.out.print("+---+---+---+---+---+---+---+\n");
			System.out.print("|");

			for (int j = 0; j < 7; j++) {
				System.out.print(" " + grille[i][j] + " " + "|");
			}
			System.out.print("\n");
		}
		System.out.print("+---+---+---+---+---+---+---+\n");
		afficherNumColonnes();
		System.out.println("\n\n");
	}

	/**
	 * M�thode nous disant si la case est pleine ou pas
	 * 
	 * @param numColonne le numero de la colonne
	 * @return un boolean indiquant si on peut continuer � jour ou pas
	 */
	public static boolean coupPossible(int numColonne) {
		boolean b = false;
		if(!estColonnePleine(numColonne)) 
		{
			b=true;
		}
		

		return b;
	}

	/**
	 * permet de savoir si une colonne est pleine ou pas
	 * @param col le num�ro de la colonne
	 * @return vraie su la colonne est pleine
	 */
	public static boolean estColonnePleine(int col) {
	return grille[0][col]!=0;
	}
	
	/**
	 * place le pion du joueur dans la colonne donn�e
	 * @param col le num�ro de la colonne
	 * @param player le num�ro du joueur
	 */
	public static void playColumn (int col , int player) {
		Joueur.setNumJoueur(player);
		Joueur.jouerCoup(col);
	}
	
	/**
	 * determine si la partie est remport�e par 
	 * un joueur
	 * @return vrai si on a 4 pions align�s
	 */
	public static boolean  aGagneJoueur() 
	{//A faire!!!
		boolean b=false;
		return b;
	}
	
	/**
	 * Permet de chercher 4 pions align�s
	 * dans la grille
	 * @return vrai si on a 4 pions de m�me
	 * 
	 */
	public static boolean hAlign() 
	{  
		int ligne =6;
		int col=0;
		int compteur=0;
		int pion=0;
		while(ligne>=0 && col<7 && !(compteur==4)) 
		{
			//si le jeu a commenc�
			if(grille[ligne][col]!=0) 
			{
				pion=grille[ligne][col];
				compteur++;
				for(int i=1;i<7;i++) 
				{
					if(pion==grille[ligne][i]) 
					{
						compteur++;
						if(compteur==4) 
						{
							return true;
						}
					}else compteur=0;
				}
			}
			if(pion!=0 && compteur==4) 
			{
				return true;
			}
		}//fin while
		
		//si on a pas de pions align�s
		return false;
	}
}
