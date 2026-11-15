import es.usal.progiii.tools.Esdia;
public class App {
    public static void main(String[] args) throws Exception {
        Person p1=new Person("",0,0);
        Person p2=new Person("",0,0);
        Person p3=new Person("",0,0);
        Person[] P = {p1, p2, p3};
        float maxa=0, maxp=0;      
        String n;
        float a, p;
        for(int i=0;i<=2;i++){
            int j=i+1;
             System.out.printf("Introdce el nombre de la %d persona: ", j);
            n=Esdia.readString("");
            P[i].setNombre(n);
            a=Esdia.readFloat("Introdce su altura: ");
            P[i].setAltura(a);
            p=Esdia.readFloat("Introdce su peso: ");
            P[i].setPeso(p);

            if(maxa<P[i].getAltura()){
                maxa=P[i].getAltura();
            }

            if(maxp<P[i].getPeso()){
                maxp=P[i].getPeso();
            }
        }
        System.out.printf("La altura máxima es %f.2 y el peso máximo es %f.2", maxa, maxp);
        }
 }
