package com.example.salesenquiry.EnquiryFrom;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salesenquiry.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static com.example.salesenquiry.R.id.Cust_id;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.Holder> {
    ArrayList<DataModel> dataView;
    Context context;
//Constructor
    public MyDataAdapter(ArrayList<DataModel> dataView,Context context) {
        this.dataView = dataView;
        this.context =context;
    }
    @Override
    public MyDataAdapter.Holder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_view,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder( MyDataAdapter.Holder holder, int position) { DataModel dataModel=dataView.get(position);
            DataModel temp=dataView.get(position);
            holder.Cust_id.setText(String.valueOf(dataView.get(position).getId()));
        holder.Cust_Name.setText(dataView.get(position).getFNAME()+" "+dataView.get(position).getLNAME());
        holder.Cust_Emailid.setText(dataView.get(position).getEMAIL());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,View_form.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.Cust_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(context,personal.class);
                intent2.putExtra("ID",temp.getId());
                intent2.putExtra("FNAME",temp.getFNAME());
                intent2.putExtra("LNAME",temp.getLNAME());
                intent2.putExtra("LOCALITY",temp.getLOCALITY());
                intent2.putExtra("CITY",temp.getCITY());
                intent2.putExtra("PINCODE",temp.getPINCODE());
                intent2.putExtra("TIME_TO_CALL",temp.getTIME_TO_CALL());
                intent2.putExtra("PHONE",temp.getPHONE());
                intent2.putExtra("ALTPHONE",temp.getALTPHONE());
                intent2.putExtra("EMAIL",temp.getEMAIL());
                intent2.putExtra("GENDER",temp.getGENDER());
                intent2.putExtra("STATUS",temp.getSTATUS());
                intent2.putExtra("OCCUPATION",temp.getOCCUPATION());
                intent2.putExtra("COMPANY_NAME",temp.getCOMPANY_NAME());
                intent2.putExtra("DESIGNATION",temp.getDESIGNATION());
                intent2.putExtra("WORK_NATURE",temp.getWORK_NATURE());
                intent2.putExtra("BUSINESS_LOCATION",temp.getBUSINESS_LOCATION());
                //need and requirement
                intent2.putExtra("CONFIGURATION",temp.getCONFIGURATION());
                intent2.putExtra("SPECIFY",temp.getSPECIFY());
                intent2.putExtra("BUDGET",temp.getBUDGET());
                intent2.putExtra("HOMELOAN",temp.getLOAN());
                intent2.putExtra("BANKNAME",temp.getBANKNAME());
                intent2.putExtra("PURCHASE",temp.getPURCHASE());
                intent2.putExtra("RESIDENTAL",temp.getRESIDENTAL());
                //about project
                intent2.putExtra("NEWSPAPER_ADV",temp.getNEWSPAPER_ADV());
                intent2.putExtra("NEWSPAPER_INSERT",temp.getNEWSPAPER_INSERT());
                intent2.putExtra("HORDING",temp.getHORDING());
                intent2.putExtra("ADVERTISMENT",temp.getADVERTISEMENT());
                intent2.putExtra("SOURCE",temp.getSOURCE());
                intent2.putExtra("TELECALLING",temp.getTELECALLING());
                intent2.putExtra("BROKER",temp.getBROKER());
                intent2.putExtra("REFER",temp.getREFER());
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent2);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataView.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView Cust_Name,Cust_Emailid,Cust_id;
        CardView cardView;
        TextView Cust_update;
        public Holder( View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.datacardView);
            Cust_id=itemView.findViewById(R.id.Cust_id);
            Cust_Name=itemView.findViewById(R.id.Cust_Name);
            Cust_Emailid=itemView.findViewById(R.id.Cust_Emailid);
            Cust_update=itemView.findViewById(R.id.Cust_update);
        }
    }
}