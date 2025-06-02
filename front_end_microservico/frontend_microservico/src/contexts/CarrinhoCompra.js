import React, { createContext, useContext, useState } from "react";

const CarrinhoContext = createContext();

export const useCarrinho = () => useContext(CarrinhoContext);

export const CarrinhoProvider = ({ children }) => {
    const [carrinho, setCarrinho] = useState([]);

    const adicionarItem = (item) => {
        setCarrinho((prevCarrinho) => {
            const itemExistente = prevCarrinho.find(produto => produto.id === item.id);
            if (itemExistente) {
                return prevCarrinho.map(produto =>
                    produto.id === item.id
                        ? { ...produto, quantidade: produto.quantidade + 1 }
                        : produto
                );
            } else {
                return [...prevCarrinho, { ...item, quantidade: 1 }];
            }
        });
    };

    const limparCarrinho = () => setCarrinho([]);

    const removerDoCarrinho = (id) => {
        setCarrinho((prev) => prev.filter(item => item.id !== id));
    };

    return (
        <CarrinhoContext.Provider value={{ carrinho, adicionarItem, limparCarrinho, removerDoCarrinho }}>
            {children}
        </CarrinhoContext.Provider>
    );
};
