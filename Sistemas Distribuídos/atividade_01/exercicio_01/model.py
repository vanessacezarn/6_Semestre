import threading

class Banco:
    """
    Classe que representa o sistema de caixa centralizado do evento, o qual é alimentado pelas vendas de fichas em 5 caixas físicos
    """    
    def __init__(self):
        """
        Inicializa o banco com saldo_central = 0
        Utiliza Lock() para controlar o acesso ao saldo_central
        """        
        self.saldo_central = 0
        self._lock= threading.Lock()

    def retornar_saldo(self):
        """
        Função utilizada para retornar o valor atual no sistema de caixa centralizado do evento
        Returns:
            int: valor atual do saldo no sistema
        """        
        with self._lock:
            return self.saldo_central

    def adicionar_saldo(self, valor):
        """
        Função para adicionar ao saldo_central o valor de venda de cada ingresso
        Args:
            valor (int): valor da venda de cada ficha
        """        
        with self._lock:
            self.saldo_central += valor

    def venda(self, valor):
        """
        Função que simula a venda de 1000 fichas
        Args:
            valor (int): valor da venda de cada ficha
        """        
        for i in range(1000):
            self.adicionar_saldo(valor)