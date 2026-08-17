import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { BrowserRouter, Routes, Route, Link, Navigate } from 'react-router-dom';
import ClientDashboard from './features/client/ClientDashboard';
import WaiterDashboard from './features/waiter/WaiterDashboard';
import ChefDashboard from './features/chef/ChefDashboard';
import AdminDashboard from './features/admin/AdminDashboard';

const queryClient = new QueryClient();

function Home() {
  return (
    <div className="min-h-screen bg-slate-950 text-white flex flex-col items-center justify-center p-6 selection:bg-violet-500 selection:text-white">
      <div className="max-w-3xl w-full text-center">
        <h1 className="text-5xl font-extrabold tracking-tight bg-clip-text text-transparent bg-gradient-to-r from-violet-400 via-pink-500 to-amber-400 mb-4">
          RestoFlow Monorepo
        </h1>
        <p className="text-slate-400 text-lg mb-12 max-w-xl mx-auto">
          Plataforma de pedidos y gestión en tiempo real para restaurantes bajo arquitectura hexagonal.
        </p>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-6 text-left">
          {/* Card Cliente */}
          <Link
            to="/cliente"
            className="group p-6 bg-slate-900 hover:bg-slate-800/80 rounded-2xl border border-slate-800/50 hover:border-violet-500/50 transition-all duration-300 shadow-lg hover:shadow-violet-950/20"
          >
            <div className="flex items-center space-x-4 mb-3">
              <span className="text-3xl">🍽️</span>
              <h2 className="text-xl font-bold text-white group-hover:text-violet-400 transition-colors">
                Portal Cliente
              </h2>
            </div>
            <p className="text-slate-400 text-sm">
              Vista del menú, carrito de compras, seguimiento de pedidos y solicitud de cuenta.
            </p>
          </Link>

          {/* Card Mesero */}
          <Link
            to="/mesero"
            className="group p-6 bg-slate-900 hover:bg-slate-800/80 rounded-2xl border border-slate-800/50 hover:border-emerald-500/50 transition-all duration-300 shadow-lg hover:shadow-emerald-950/20"
          >
            <div className="flex items-center space-x-4 mb-3">
              <span className="text-3xl">🧑‍🍳</span>
              <h2 className="text-xl font-bold text-white group-hover:text-emerald-400 transition-colors">
                Panel Mesero
              </h2>
            </div>
            <p className="text-slate-400 text-sm">
              Validación humana de pedidos por mesa, control de estados y cobros presenciales.
            </p>
          </Link>

          {/* Card Chef */}
          <Link
            to="/chef"
            className="group p-6 bg-slate-900 hover:bg-slate-800/80 rounded-2xl border border-slate-800/50 hover:border-orange-500/50 transition-all duration-300 shadow-lg hover:shadow-orange-950/20"
          >
            <div className="flex items-center space-x-4 mb-3">
              <span className="text-3xl">🔥</span>
              <h2 className="text-xl font-bold text-white group-hover:text-orange-400 transition-colors">
                Cola del Chef
              </h2>
            </div>
            <p className="text-slate-400 text-sm">
              Monitoreo de pedidos en cocina, preparación de platos y gestión de stock del menú.
            </p>
          </Link>

          {/* Card Admin */}
          <Link
            to="/admin"
            className="group p-6 bg-slate-900 hover:bg-slate-800/80 rounded-2xl border border-slate-800/50 hover:border-sky-500/50 transition-all duration-300 shadow-lg hover:shadow-sky-950/20"
          >
            <div className="flex items-center space-x-4 mb-3">
              <span className="text-3xl">⚙️</span>
              <h2 className="text-xl font-bold text-white group-hover:text-sky-400 transition-colors">
                Administración
              </h2>
            </div>
            <p className="text-slate-400 text-sm">
              Gestión de base de datos de usuarios, catálogo del menú, mesas e informes financieros.
            </p>
          </Link>
        </div>
      </div>
    </div>
  );
}

export default function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/cliente" element={<ClientDashboard />} />
          <Route path="/mesero" element={<WaiterDashboard />} />
          <Route path="/chef" element={<ChefDashboard />} />
          <Route path="/admin" element={<AdminDashboard />} />
          <Route path="*" element={<Navigate to="/" replace />} />
        </Routes>
      </BrowserRouter>
    </QueryClientProvider>
  );
}
