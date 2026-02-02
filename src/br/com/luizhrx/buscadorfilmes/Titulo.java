package br.com.luizhrx.buscadorfilmes;

import com.google.gson.annotations.SerializedName;

public record Titulo(@SerializedName("Title")String nome,
                     @SerializedName("Year")String ano,
                     @SerializedName("Genre")String genero,
                     @SerializedName("Runtime")String duraco,
                     @SerializedName("Director")String diretor,
                     String Response){
}
