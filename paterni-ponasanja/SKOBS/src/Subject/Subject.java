

package Subject;
import Observer.Observer;

public class Subject
{ Observer cs[];
  public Subject(){cs = new Observer[3];}
  public void setObserver(int index,Observer cs1) {cs[index] = cs1;}
  public void Notify(int brojPrijave)
    {
       for (int i=0;i<cs.length;i++)
          {cs[i].Update(brojPrijave);}
    }
}