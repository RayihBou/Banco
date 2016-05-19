import java.io.*;
import java.util.*;

public class Bancos{
	
  public static void main(String[] args) throws IOException{
	  
	  Scanner sc = new Scanner(System.in);
	  //Declaraciones
	  int ncli = 0;
	  Byte opc = 0;
	  int registrocli = 0;
	  int registroope = 0;
	  int xcant = 10;
	  Byte oper = 0;

	  String operaciones[][] = new String[xcant][4];
	  System.out.println("Con cuantos clientes desea trabajar?");
	  do{
		  ncli = sc.nextInt();
		  if(ncli == 0){
			  System.out.println("Escriba una cantidad valida:");
		  }
	  }while(ncli == 0);
	  String clientes[][]    = new String[ncli][4];
	  do{
		  System.out.println("MENU DE OPCIONES PRINCIPAL ");
		  System.out.println("0.- Salir");
		  System.out.println("1.- Crear cliente");
		  System.out.println("2.- Operaciones");
		  System.out.println("3.- Consulta de Clientes");
		  System.out.println("4.- Reporte de operaciones");
		  System.out.print("\nEliga su opcion = ");
		  do{
			  opc = sc.nextByte();
			   if (opc > 4){
				 System.out.println("Escriba una opcion valida (0 - 4):");
			   }
		  }while(opc > 4);

		  switch(opc){
		  // Agregar nueva Aerolinea
		  case 1: System.out.print("\n");
		  System.out.println("== Crear Cliente ==");
		  System.out.print("\n");

		  System.out.print("C.I.: ");

		  clientes[registrocli][0] = sc.nextLine();

		  System.out.print("Nombre: ");
		  clientes[registrocli][1] = sc.nextLine();
		  System.out.print("Direccion: ");
		  clientes[registrocli][2] = sc.nextLine();


		  int longitud = 0;
          do{
			  System.out.print("Numero de cuenta: ");
   			  clientes[registrocli][3] = sc.nextLine();
	  		  longitud = clientes[registrocli][3].length();
	  		  if(longitud != 20){
	  		  System.out.println("Indique un numero de cuenta de 20 digitos");
		     }
	      }while(longitud != 20);
	      System.out.println("Debe incluir al menos un deposito");
          operaciones[registroope][0] = "DP";
          operaciones[registroope][1] = clientes[registrocli][3];
		  System.out.print("Referencia o numero de deposito: ");
		  operaciones[registroope][2] = sc.nextLine();
		  System.out.print("Monto: ");
		  operaciones[registroope][3] = sc.nextLine();

          registroope += 1;
		  registrocli += 1;
		  System.out.print("\n");

        break;
		  case 2: System.out.print("\n");
	      if(registrocli == 0){
			  System.out.println("Debe incluir al menos un cliente");
			  System.out.print("\n");
			  break;

		  }
			oper = 0;
          System.out.println("== Operaciones ==");
		  System.out.print("\n");
		  System.out.println("== Indique la operacion a realizar ==");
          System.out.println("0 = Depositos");
          System.out.println("1 = Retiros");
			do{
			   oper = sc.nextByte();
			   if (oper > 1){
				 System.out.println("Escriba una opcion valida (0 - 1):");
			 }
			}while(oper > 1);
          if (oper == 0){
          		operaciones[registroope][0] = "DP";
		     }
          if (oper == 1){
          		operaciones[registroope][0] = "RT";
		     }
		  oper = 0;
    	  System.out.println("== Cuentas disponibles ==");
    	  for(int i = 0;i<ncli;i++){
			  if(clientes[i][0] != null) {
			  System.out.println("Codigo: "+i+" C.I.: "+clientes[i][0]+" Nombre: "+clientes[i][1]+" Numero de cta.: "+clientes[i][3]);
		      }
			 }
          System.out.println("Codigo de cuenta a usar: ");
			do{
			   oper = sc.nextByte();
			   if (oper > 1){
				 System.out.println("Codigo de cuenta invalido");
			 }
			}while(oper > 1);
          System.out.print("\n");
          operaciones[registroope][1] = clientes[oper][3];
          System.out.print("Cuenta: "+operaciones[registroope][1]);
		  System.out.print("Referencia o numero de deposito: ");
		  operaciones[registroope][2] = sc.nextLine();
		  System.out.print("Monto: ");
		  operaciones[registroope][3] = sc.nextLine();
		  registroope += 1;
		  System.out.print("\n");

        break;
		  case 3:System.out.print("\n");
         System.out.println("== Datos de Clientes ==");
    	  for(int i = 0;i<ncli;i++){
			  if (clientes[i][0] != null) {
			  System.out.print("Codigo: "+i+" C.I.: "+clientes[i][0]+" Nombre: "+clientes[i][1] );
		      }
			 }
		 System.out.print("\n");
		 System.out.print("\n");
		 break;
 	 case 4:System.out.print("\n");
      int cantdep = 0;
      double montodep = 0;
      double totmontodep = 0;
      int cantret = 0;
      double montoret = 0;
      double totmontoret = 0;

         System.out.println("== Depositos ==");
      for(int i = 0;i<xcant;i++){
	  	  if(operaciones[i][0] != null) {
			  if(operaciones[i][0].compareTo("DP") ==0){
				montodep = Double.parseDouble(operaciones[i][3]);
                cantdep += 1;
                totmontodep += montodep;
			}//if
			  if(operaciones[i][0].compareTo("RT") ==0){
				montoret = Double.parseDouble(operaciones[i][3]);
                cantret += 1;
                totmontoret += montodep;
			}//if
		  }//if
	  }//for
      System.out.println("Cantidad de depositos: "+cantdep);
      System.out.println("Monto total de depositos: "+totmontodep);
      System.out.println("Cantidad de retiros: "+cantret);
      System.out.println("Monto total de retiros: "+totmontoret);
      System.out.print("\n");
   }//switch
   }while(opc != 0);

}
}