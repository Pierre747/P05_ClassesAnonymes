/*
 * On va devoir créer deux types abstraits :
 * - Une classe Abstract FigureGeometrique
 * - Une interface IImposable
 * 
 * A partir de chaque type abstrait, on va créer deux classes anonymes et les instancier dans le Main()
 * 
 */

package fr.etude;

public class MonApplication
{

	public static void main(String[] args)
	{
		// On veut créer un rectangle de 3 sur 5 par héritage et instanciation de la classe obtenue à partir de FigureGeometrique
		
		FigureGeometrique rectangle = new FigureGeometrique(new double[] {3, 5}) // il faut penser à envoyer les dimensions en argument
				{
					@Override
					public double calculerAire()
					{
						return tb[0]*tb[1];
					}
				};
				
				System.out.println("Mon rectangle :");
				System.out.println(rectangle);
				System.out.println();
				
				// On veut créer un cercle de rayon de 1
				
		FigureGeometrique cercle = new FigureGeometrique(new double[] {1})
				{
					@Override
					public double calculerAire()
					{
						return Math.PI * Math.pow(tb[0], 2);
					}
				};
				
				System.out.println("Mon cercle :");
				System.out.println(cercle);
				System.out.println();
				
				
				// ------------------------------------------------------------------------- //
				
				
				// Créer une instance d'une classe interne anonyme par l'implémentation de l'interface IImposable
		
				IImposable employe = new IImposable()
				{
					@Override
					public double calculerImpot(double[] tbDonnees)
					{
						// en supposant que le revenu de l'employé arrive dans le premier élément du tableau
						// et le coefficient d'imposition dans le deuxième élément, l'impôt dû est :
						return tbDonnees[0] * tbDonnees[1];
					}
				};
				
				System.out.println("Impot employe : " +  employe.calculerImpot(new double[] {24000, 0.1}));
				
				
				// ------------------------------------------------------------------------- //
				
				// Créer une deuxième instance de d'une classe anonyme qui implémente l'interface IImposable :
				
				IImposable taxeHabitation = new IImposable()
				{
					@Override
					public double calculerImpot(double[] tbDonnees)
					{
						// Je passe le département où se trouve l'appartement dans une premier tableau
						// et la surface dans un deuxième tableau
						
						// Je récupère ces données
						int departement = (int)tbDonnees[0];
						double surface = tbDonnees[1];
						
						double coef;
						
						switch (departement)
						{
							case 75001:
							{
								coef = 10;
								break;
							}
							case 86000:
								coef = 3;
								break;
							default:
								coef = 5;
							}
							return surface * coef;
						}
				}; // fin de création de classe anonyme
				
				// afficher l'impot taxe d'habitation
				
				System.out.println(taxeHabitation.getClass().getName() + ", taxe d'habitation : " + taxeHabitation.calculerImpot(new double[] {86000, 100}) + " euros");
				System.out.println();
				
	} // Fin du Main

} // Fin de MonApplication

abstract class FigureGeometrique
{
	protected double[] tb;

	public FigureGeometrique(double[] tb)
	{
		this.tb = tb;
	}

	@Override
	public String toString()
	{
		return this.getClass().getName() + " aire : " + calculerAire();
	}

	public abstract double calculerAire();
	
	
	
} // Fin de FigureGeometrique

// définir une interface

interface IImposable
{
	  public double calculerImpot(double[] tbDonnees);
}