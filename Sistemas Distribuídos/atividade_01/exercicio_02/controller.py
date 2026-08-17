import threading
from concurrent.futures import ThreadPoolExecutor

class Controller:
    """
        Classe responsável por popular os relatórios das filiais e somar as vendas de cada filial, exibindo o valor total ao final
        """  

    def __init__(self, model, view):
        """
        Inicializa a controller
        Args:
            model (Model): responsável por gerenciar os dados do sistema
            view (View): responsável pela exibição das informações
        """     
        self.model = model
        self.view = view

    def executar(self):
        """
        Função responsável por popular os relatórios das filiais e somar as vendas de cada filial, exibindo o valor total ao final
        """   
        filial_1 = []
        filial_2 = []
        filial_3 = []
        filial_4 = []

        self.model.popular_relatorio(filial_1, 1000)
        self.model.popular_relatorio(filial_2, 1000)
        self.model.popular_relatorio(filial_3, 1000)
        self.model.popular_relatorio(filial_4, 1000)

        with ThreadPoolExecutor() as executor:
            resultados = executor.map(
                self.model.somar_vendas,
                [filial_1, filial_2, filial_3, filial_4],
            )

        soma_final = sum(resultados)
        self.view.exibir_valor_total(soma_final)
