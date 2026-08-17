export default function WaiterDashboard() {
  return (
    <div className="min-h-screen bg-slate-50 flex flex-col items-center justify-center p-6">
      <div className="bg-white p-8 rounded-2xl shadow-xl max-w-md w-full text-center border border-slate-100">
        <h1 className="text-3xl font-bold text-slate-800 mb-2">RestoFlow 🧑‍🍳</h1>
        <p className="text-slate-500 mb-6">Panel del Mesero</p>
        <div className="p-4 bg-emerald-50 text-emerald-700 rounded-xl font-medium mb-4">
          Control de Mesas y Pedidos
        </div>
        <p className="text-sm text-slate-400">Inicia sesión para gestionar los pedidos en tiempo real.</p>
      </div>
    </div>
  );
}
