export default function ClientDashboard() {
  return (
    <div className="min-h-screen bg-slate-50 flex flex-col items-center justify-center p-6">
      <div className="bg-white p-8 rounded-2xl shadow-xl max-w-md w-full text-center border border-slate-100">
        <h1 className="text-3xl font-bold text-slate-800 mb-2">RestoFlow 🍽️</h1>
        <p className="text-slate-500 mb-6">Portal de Clientes</p>
        <div className="p-4 bg-violet-50 text-violet-700 rounded-xl font-medium mb-4">
          Mesa no asignada
        </div>
        <p className="text-sm text-slate-400">Escanea un código QR o inicia una nueva sesión.</p>
      </div>
    </div>
  );
}
