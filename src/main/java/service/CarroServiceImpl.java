package service;

import dao.CarroDAO;
import dao.DaoFactory;
import model.Carro;

public class CarroServiceImpl implements CarroService{
    private CarroDAO carroDao;

    public CarroServiceImpl() {
        this.carroDao = DaoFactory.getCarroDAO();
    }

    @Override
    public boolean save(Carro entity) {
        boolean b = false;

        if (entity != null) {
            b = this.carroDao.save(entity);
        }

        return b;
    }

    @Override
    public Carro findByIdCarro(int idCarro) {
        return this.carroDao.findByIdCarro(idCarro);
    }
}
