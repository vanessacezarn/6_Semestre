import threading

class Controller:
    """
    Classe responsávelpor controlar a execução das vendas
    """    
    def __init__(self, model, view):
        """
        Inicializa a controller
        Args:
            model (Banco): responsável pelo controle do saldo central
            view (View): responsável pela exibição das informações
        """        
        self.model = model
        self.view = view

    def executar(self):
        """
        Função responsável pela simulção das vendas em 5 caixas, cada caixa é representado por uma thread e ao final a soma das vendas é exibida
        """        
        t1 = threading.Thread(target=self.model.venda, args=(10,))
        t2 = threading.Thread(target=self.model.venda, args=(10,))
        t3 = threading.Thread(target=self.model.venda, args=(10,))
        t4 = threading.Thread(target=self.model.venda, args=(10,))
        t5 = threading.Thread(target=self.model.venda, args=(10,))

        t1.start()
        t2.start()
        t3.start()
        t4.start()
        t5.start()

        t1.join()  
        t2.join()
        t3.join()
        t4.join()
        t5.join()

        self.view.exibir_saldo_final(self.model.saldo_central)