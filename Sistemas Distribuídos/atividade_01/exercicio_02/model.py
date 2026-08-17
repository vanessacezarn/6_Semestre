import random

class Model:
    """
    Classe que representa a model, responsável por gerenciar os dados do sistema, incluindo a simulação de vendas e o cálculo da soma da filial.    
    """  
   
    def popular_relatorio(self, relatorio_vendas, quantidade):
        """
        Função utilizada para popular a lista relatorio_vendas com valores aleatórios simulando as vendas em cada filial
        Args:
            relatorio_vendas (list): Lista que armazena as vendas de cada filial
            quantidade (int): Número de vendas a serem simuladas
        """ 
        for i in range(quantidade):
            relatorio_vendas.append(random.randint(1, 1000))


    def somar_vendas(self, relatorio_vendas):
        """
        Função utilizada para somar o total das vendas de uma filial
        Args:
            relatorio_vendas (list): Lista que armazena as vendas de cada filial
        Returns:
            int: Retorna o total das vendas de uma filial
        """ 
        total = 0
        for i in relatorio_vendas:
            total += i
        return total        