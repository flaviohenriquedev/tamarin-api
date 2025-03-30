package com.br.tamarin.root.crud;

import com.br.tamarin.root.model.EntidadePadrao;

public class Crud<E extends EntidadePadrao> {

    public void onExecuteService(OnExecuteServiceCallBack callBack) {
        callBack.executar();
    }

    protected interface OnExecuteServiceCallBack{
        void executar();
        default String getMensagem(){
            return "operacao.realizada.sucesso";
        }
    }
}
