export default function ChefDashboard() {
  return (
    <div className="min-h-screen bg-slate-50 flex flex-col items-center justify-center p-6">
      <div className="bg-white p-8 rounded-2xl shadow-xl max-w-md w-full text-center border border-slate-100">
        <h1 className="text-3xl font-bold text-slate-800 mb-2">RestoFlow 🔥</h1>
        <p className="text-slate-500 mb-6">Cocina / Chef</p>
        <div className="p-4 bg-orange-50 text-orange-700 rounded-xl font-medium mb-4">
          Cola de Preparación
        </div>
        <p className="text-sm text-slate-400">Pedidos activos en preparación aparecerán aquí.</p>
      </div>
    </div>
  );
}
