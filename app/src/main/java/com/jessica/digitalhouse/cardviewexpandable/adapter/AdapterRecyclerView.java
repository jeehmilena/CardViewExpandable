package com.jessica.digitalhouse.cardviewexpandable.adapter;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jessica.digitalhouse.cardviewexpandable.R;
import com.jessica.digitalhouse.cardviewexpandable.model.Grade;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private List<Grade> gradeList;
    private Context context;

    public AdapterRecyclerView(List<Grade> list, Context context){
        this.gradeList = list;
        this.context = context;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Grade grade = gradeList.get(position);
        holder.bind(grade);
    }

    @Override
    public int getItemCount() {
        return gradeList.size();
    }




    //classe ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCurso;
        private TextView txtProfessor;
        private TextView txtHorario;
        private ImageView btnExpand;
        private int minHeight;
        private CardView cardView;
        private TextView diaSemana;
        private ImageView imagemCabecalho;

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public ViewHolder(View itemView) {
            super(itemView);

            diaSemana = itemView.findViewById(R.id.txtDiaSemana);
            txtCurso = itemView.findViewById(R.id.nomeCurso);
            txtProfessor = itemView.findViewById(R.id.nomeProfessor);
            txtHorario = itemView.findViewById(R.id.horarios);
            btnExpand = itemView.findViewById(R.id.btnExpand);
            cardView = itemView.findViewById(R.id.cardView);
            imagemCabecalho = itemView.findViewById(R.id.img);

            //Código para expandir o CardView
            WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dimension = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(dimension);

            final int height = dimension.heightPixels;

            cardView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

                @Override
                public boolean onPreDraw() {
                    cardView.getViewTreeObserver().removeOnPreDrawListener(this);
                    minHeight = cardView.getHeight();
                    ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                    layoutParams.height = minHeight;
                    cardView.setLayoutParams(layoutParams);

                    return true;
                }
            });


            btnExpand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleCardViewnHeight(height);
                }
            });

        }


        //Método do bind para setar os valores aos compentes(não faz parte do código para expandir o CardView
        public void bind(Grade grade){
            diaSemana.setText(grade.getDiaSemana());
            txtCurso.setText(grade.getNomeCurso());
            txtProfessor.setText(grade.getNomeProfessor());
            txtHorario.setText(grade.getHorario());
            imagemCabecalho.setImageResource(grade.getImagem());
        }

        //Métodos para a expansão do CardView
        private void toggleCardViewnHeight(int height) {

            if (cardView.getHeight() == minHeight) {
                // expand
                expandView(height); //'height' is the height of screen which we have measured already.

            } else {
                // collapse
                collapseView();

            }
        }

        public void collapseView() {

            ValueAnimator anim = ValueAnimator.ofInt(cardView.getMeasuredHeightAndState(),
                    minHeight);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                    layoutParams.height = val;
                    cardView.setLayoutParams(layoutParams);

                }
            });
            anim.start();
        }

        public void expandView(int height) {

            ValueAnimator anim = ValueAnimator.ofInt(cardView.getMeasuredHeightAndState(),
                    height);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                    layoutParams.height = val;
                    cardView.setLayoutParams(layoutParams);
                }
            });
            anim.start();

        }


    }
}
