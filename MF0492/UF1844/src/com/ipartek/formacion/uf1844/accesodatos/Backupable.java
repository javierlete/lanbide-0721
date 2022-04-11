package com.ipartek.formacion.uf1844.accesodatos;

public interface Backupable<T> {
	void backup(Iterable<T> objetos);
	Iterable<T> restore();
}
