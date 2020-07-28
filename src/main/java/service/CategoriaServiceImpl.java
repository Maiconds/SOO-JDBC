package service;

import dao.CarroDAO;
import dao.CategoriaDAO;
import dao.DaoFactory;
import model.Carro;
import model.Categoria;

public class CategoriaServiceImpl implements CategoriaService{
    private CategoriaDAO categoriaDAO;

    public CategoriaServiceImpl() { this.categoriaDAO = DaoFactory.getCategoriaDAO(); }

    @Override
    public boolean save(Categoria entity) {
        boolean b = false;

        if (entity != null) {
            b = this.categoriaDAO.save(entity);
        }

        return b;
    }

    @Override
    public Categoria findByIdCategoria(int idCategoria) {
        return this.categoriaDAO.findByIdCategoria(idCategoria);
    }
}
