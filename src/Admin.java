import java.io.*;
import java.util.ArrayList;

public class Admin implements Serializable {
    private static final long SerialVersionUID = 6523585098897757770L;
    public static ArrayList<Admin> adminArrayList = new ArrayList<Admin>();

    /** Data field for sign in */
    private String Username;
    private String Password;
    private static int AdminID = 0;

    int count = 0;

    private static void Serialize(){
        try{
            FileOutputStream fos = new FileOutputStream("TestAdmin1");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(adminArrayList);
            oos.close();
            fos.close();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void Deserialize(){
        /** clear Arraylist */
        adminArrayList.clear();
        try{
            FileInputStream fis = new FileInputStream("TestAdmin1");
            ObjectInputStream ois = new ObjectInputStream(fis);
            adminArrayList = (ArrayList) ois.readObject();
            fis.close();
            ois.close();
        }
        catch (FileNotFoundException ex){
            return;
        }
        catch (ClassNotFoundException class_ex){
            class_ex.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    /** No arg constructor */
    public Admin(){}

    /** user defined constructor */
    public Admin(String Username, String Password) {
      /*  if(Password.length() > 16)
            throw new MaxCharException(Password);*/
        this.AdminID = ++count;
        setUsername(Username);
        setPassword(Password);
        /** Add admin to arraylist */
        adminArrayList.add(this);
        /** Serialize */
        Serialize();
    }

    /** Setter */
    public void setPassword(String password) {
        Password = password;
    }

    public void setUsername(String username) { Username = username; }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public static Admin getAdminByName(String username) {
        for (Admin a : Admin.adminArrayList)
            if (a.getUsername().equals(username))
                return a;
        return null;
    }
}
