package beans;


import beans.PaymentsBeanRemote;
import common.infrastructure.ISerializable;
import common.settings.Constants;

import javax.ejb.Stateless;
import java.io.*;
import java.util.ArrayList;

@Stateless(mappedName = "doPayment")
public class PaymentsBean implements PaymentsBeanRemote {

    @Override
    public void addPayment(ISerializable model) throws IOException {
        
        
        FileWriter fw = new FileWriter(Constants.FileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(model.getFileRepresentation());
        bw.close();
    }

    @Override
    public ArrayList<String> getAllPayments() throws IOException {
        ArrayList<String> result = new ArrayList<String>();

        ensureFileExist();
       
        FileReader fr = new FileReader(Constants.FileName);
        BufferedReader br = new BufferedReader(fr);

        while (br.ready()) {
            result.add(br.readLine());
        }

        br.close();
        fr.close();

        return result;
    }
    
    private void ensureFileExist() throws IOException
    {
        File yourFile = new File(Constants.FileName);
        yourFile.createNewFile(); // if file already exists will do nothing 
    }
}
